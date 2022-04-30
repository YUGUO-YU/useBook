package com.usedbook.service.impl;

import com.usedbook.mapper.SessionListMapper;
import com.usedbook.pojo.SessionList;
import com.usedbook.service.SessionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionListServiceImpl implements SessionListService {

    @Autowired
    SessionListMapper sessionListMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SessionList sessionList) {
        return sessionListMapper.inserts(sessionList);
    }

    @Override
    public int insertSelective(SessionList sessionList) {
        return 0;
    }

    @Override
    public SessionList selectByPrimaryKey(String id) {
        return sessionListMapper.selectById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SessionList sessionList) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SessionList sessionList) {
        return 0;
    }

    @Override
    public List<String> selectUserIdByUserId(String id) {
        return sessionListMapper.selectUserIdByUserId(id);
    }

    @Override
    public List<SessionList> selectByUserId(String id) {
        return sessionListMapper.selectByUserId(id);
    }

    @Override
    public Integer selectIdByUser(String fromId, String toId) {
        return sessionListMapper.selectIdByUser(fromId, toId);
    }

    @Override
    public SessionList select(SessionList sessionList) {
        return null;
    }

    @Override
    public void addUnReadCount(String userId, String toUserId) {

    }

    @Override
    public void delUnReadCount(Integer fromUserId, Integer toUserId) {

    }
}
