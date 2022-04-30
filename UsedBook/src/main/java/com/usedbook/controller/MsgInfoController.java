package com.usedbook.controller;


import com.usedbook.common.bean.AjaxResult;
import com.usedbook.mapper.MsgInfoMapper;
import com.usedbook.mapper.SessionListMapper;
import com.usedbook.pojo.MsgInfo;
import com.usedbook.pojo.SessionList;
import com.usedbook.service.SessionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class MsgInfoController {

    @Autowired
    private MsgInfoMapper msgInfoMapper;

    @Autowired
    private SessionListMapper seesionListMapper;

    @Autowired
    SessionListService sessionListService;

    // 消息列表
    @GetMapping("/msgList")
    public AjaxResult<?> msgList(@RequestParam String sessionId){
        System.out.println("sessionId"+sessionId);
        SessionList sessionList = sessionListService.selectByPrimaryKey(sessionId);
        if(sessionList == null){
            return AjaxResult.success();
        }
        String fromUserId = sessionList.getUserId();
        String toUserId = sessionList.getToUserId();
        List<MsgInfo> msgInfoList = msgInfoMapper.selectMsgList(fromUserId,toUserId);
        // 更新消息已读
        msgInfoMapper.msgRead(fromUserId, toUserId);
        // 更新会话里面的未读消息
        seesionListMapper.delUnReadCount(fromUserId, toUserId);
        return AjaxResult.success(msgInfoList);
    }


}
