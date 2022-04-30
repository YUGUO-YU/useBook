package com.usedbook.service;

import com.usedbook.pojo.SessionList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SessionListService {
    int deleteByPrimaryKey(Integer id);

    int insert(SessionList sessionList);

    int insertSelective(SessionList sessionList);

    SessionList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SessionList sessionList);

    int updateByPrimaryKey(SessionList sessionList);

    List<String> selectUserIdByUserId(String id);

    List<SessionList> selectByUserId(String id);

    Integer selectIdByUser(@Param("fromId") String fromId, @Param("toId") String toId);

    SessionList select(SessionList sessionList);

    void addUnReadCount(@Param("userId") String userId, @Param("toUserId") String toUserId);

    void delUnReadCount(@Param("fromUserId") Integer fromUserId, @Param("toUserId") Integer toUserId);
}
