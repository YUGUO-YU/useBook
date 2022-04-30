package com.usedbook.controller;

import com.usedbook.common.bean.AjaxResult;
import com.usedbook.mapper.SessionListMapper;
import com.usedbook.mapper.UserMapper;
import com.usedbook.pojo.SessionList;
import com.usedbook.pojo.User;
import com.usedbook.service.SessionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SessionListMapper seesionListMapper;

    @Autowired
    SessionListService sessionListService;

    /**
     * 已建立会话
     */
    @GetMapping("/sessionList/already")
    public AjaxResult<?> sessionListAlready(@RequestParam String id){
        List<SessionList> sessionLists = seesionListMapper.selectByUserId(id);
        return  AjaxResult.success(sessionLists);
    }

    // 可建立会话的用户
    @GetMapping("/sessionList/not")
    public AjaxResult<?> sessionListNot(@RequestParam String id){
        List<String> list = sessionListService.selectUserIdByUserId(id);
        list.add(id);
        List<User> cloudList = userMapper.getCloudList(list);
        return AjaxResult.success(cloudList);
    }

    // 创建会话
    @GetMapping("/createSession")
    public AjaxResult<?> createSession(@RequestParam(value = "fromId") String fromId, @RequestParam(value = "toUserId") String toId, @RequestParam(value = "toUserName") String listName){
        System.out.println("访问"+fromId+" "+toId+"to"+listName);
        SessionList sessionList = new SessionList();
        sessionList.setUserId(fromId);
        sessionList.setUnReadCount(0);
        sessionList.setListName(listName);
        sessionList.setToUserId(toId);
        //sessionListService.insert(sessionList);
        // 判断对方和我建立会话没有？ 没有也要建立
        Integer integer = sessionListService.selectIdByUser(toId, fromId);
        if (integer == null || integer <= 0){
            sessionListService.insert(sessionList);
        }
        if (integer == null || integer <= 0){
            User user = userMapper.selectById(fromId);
            sessionList.setUserId(toId);
            sessionList.setToUserId(fromId);
            sessionList.setListName(user.getUserName());
            sessionListService.insert(sessionList);
        }
        SessionList sessionList1 = seesionListMapper.selectSessionId(fromId,toId,listName);
        System.out.println("listName"+sessionList1);
        return AjaxResult.success(sessionList1);
    }

    // 删除会话
    @GetMapping("/delSession")
    public AjaxResult<?> delSession(@RequestParam Integer sessionId){
        seesionListMapper.deleteByPrimaryKey(sessionId);
        return AjaxResult.success();
    }

}
