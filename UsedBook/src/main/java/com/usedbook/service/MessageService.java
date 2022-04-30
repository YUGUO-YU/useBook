package com.usedbook.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedbook.pojo.Message;

import java.util.Map;

public interface MessageService {

    Page<Message> selectListPage(Map<String, Object> map);

    int addMessage(Message id);

    Page<Message> selectListPageByUser(Map<String, Object> map);

    int delete(String id, String pId);

    public int deletebyFid(String fid) throws Exception;
}
