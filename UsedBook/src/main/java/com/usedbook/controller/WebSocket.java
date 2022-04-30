package com.usedbook.controller;


import com.usedbook.common.utils.CurPool;
import com.usedbook.common.utils.JsonUtils;
import com.usedbook.common.utils.SpringContextUtil;
import com.usedbook.mapper.MsgInfoMapper;
import com.usedbook.mapper.SessionListMapper;
import com.usedbook.mapper.UserMapper;
import com.usedbook.pojo.MsgInfo;
import com.usedbook.pojo.SessionList;
import com.usedbook.pojo.User;
import com.usedbook.service.MsgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RestController
@ServerEndpoint("/websocket/{userId}/{sessionId}")
//此注解相当于设置访问URL
public class WebSocket {

    @Autowired
    SessionListMapper sessionListMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    MsgInfoMapper msgInfoMapper;

    @Autowired
    MsgInfoService msgInfoService;

    private Session session;


    @OnOpen
    public void onOpen(Session session, @PathParam(value="userId") String userId, @PathParam(value="sessionId") String sessionId) {
        this.session = session;
        CurPool.webSockets.put(userId,this);
        List<Object> list = new ArrayList<>();
        list.add(sessionId);
        list.add(session);
        CurPool.sessionPool.put(userId , list);
        System.out.println("【websocket消息】有新的连接，总数为:"+CurPool.webSockets.size());
    }

    @OnClose
    public void onClose() {
        // 断开连接删除用户删除session
        String userId = this.session.getRequestParameterMap().get("userId").get(0);
        CurPool.sessionPool.remove(userId);
        CurPool.webSockets.remove(userId);
        if (userMapper == null){
            this.userMapper = (UserMapper) SpringContextUtil.getBean("userMapper");
        }
        User user = userMapper.selectById(userId);
        CurPool.curUserPool.remove(user.getUserName());
        System.out.println("【websocket消息】连接断开，总数为:"+CurPool.webSockets.size());
    }

    @OnMessage
    public void onMessage(String message,@PathParam(value="sessionId") String sessionId) {
        //String sessionId = this.session.getRequestParameterMap().get("sessionId").get(0);
        System.out.println("sessionId"+sessionId);
        if (sessionId == null){
            System.out.println("sessionId 错误");
        }
        // 在这里无法注入Mapper所以使用这种方式注入Mapper
        if (sessionListMapper == null){
            this.sessionListMapper = (SessionListMapper)SpringContextUtil.getBean("sessionListMapper");
        }
        if (userMapper == null){
            this.userMapper = (UserMapper)SpringContextUtil.getBean("userMapper");
        }
        if (msgInfoMapper == null){
            this.msgInfoMapper = (MsgInfoMapper)SpringContextUtil.getBean("msgInfoMapper");
        }
//        if (msgInfoService == null){
//            this.msgInfoService = (MsgInfoService)SpringContextUtil.getBean("msgInfoService");
//        }
        SessionList sessionList = sessionListMapper.selectByPrimaryKey(sessionId);
        System.out.println("sessionList"+sessionList);
        User user = userMapper.selectById(sessionList.getUserId());
        System.out.println("user"+user);
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setContent(message);
        msgInfo.setCreateTime(new Date());
        msgInfo.setFromUserId(sessionList.getUserId());
        msgInfo.setFromUserName(user.getUserName());
        msgInfo.setToUserId(sessionList.getToUserId());
        msgInfo.setToUserName(sessionList.getListName());
        msgInfo.setUnReadFlag(0);
        // 消息持久化
        msgInfoMapper.inserts(msgInfo);

        // 判断用户是否存在，不存在就结束
        List<Object> list = CurPool.sessionPool.get(sessionList.getToUserId());
        if (list == null || list.isEmpty()){
            // 用户不存在，更新未读数
            sessionListMapper.addUnReadCount(sessionList.getToUserId(),sessionList.getUserId());
        }else{
            // 用户存在，判断会话是否存在
            String id = sessionListMapper.selectIdByUser(sessionList.getToUserId(), sessionList.getUserId())+"";
            String o = list.get(0) + "";
            System.out.println("id"+id+"o"+list.get(0));
            if (id.equals(o)){
                // 会话存在直接发送消息
                sendTextMessage(sessionList.getToUserId(), JsonUtils.objectToJson(msgInfo));
            }else {
                // 判断会话列表是否存在
                if (id == null || "".equals(id) || "null".equals(id)){
                    // 新增会话列表
                    SessionList tmpSessionList = new SessionList();
                    tmpSessionList.setUserId(sessionList.getToUserId());
                    tmpSessionList.setToUserId(sessionList.getUserId());
                    tmpSessionList.setListName(user.getUserName());
                    tmpSessionList.setUnReadCount(1);
                    sessionListMapper.insert(tmpSessionList);
                }else {
                    // 更新未读消息数量
                    sessionListMapper.addUnReadCount(sessionList.getToUserId(),sessionList.getUserId());
                }
                // 会话不存在发送列表消息
                List<SessionList> sessionLists = sessionListMapper.selectByUserId(sessionList.getToUserId());
                sendTextMessage(sessionList.getToUserId() ,JsonUtils.objectToJson(sessionLists));
            }
        }
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    // 此为广播消息
//    public void sendAllMessage(String message) {
//        for(WebSocket webSocket : webSockets) {
//            System.out.println("【websocket消息】广播消息:"+message);
//            try {
//                webSocket.session.getAsyncRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    // 此为单点消息 (发送文本)
    public void sendTextMessage(String userId, String message) {
        Session session = (Session)CurPool.sessionPool.get(userId).get(1);
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息 (发送对象)
//    public void sendObjMessage(String sessionId, Object message) {
//        Session session = CurPool.sessionPool.get(sessionId);
//        if (session != null) {
//            try {
////                session.getAsyncRemote().sendObject(message);
//                session.getBasicRemote().sendText(JsonUtils.objectToJson(message));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

}