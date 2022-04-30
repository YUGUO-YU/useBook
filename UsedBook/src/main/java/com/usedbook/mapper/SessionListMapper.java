package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.SessionList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionListMapper extends BaseMapper<SessionList> {
    @Delete("delete from session_list where id = #{id,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer id);

//    @Override
//
    @Insert("insert into session_list (id, user_id, to_user_id,list_name,un_read_count) values (#{id,jdbcType=INTEGER}, #{userId}, #{toUserId}, #{listName,jdbcType=VARCHAR},#{unReadCount,jdbcType=INTEGER})")
    int inserts(SessionList sessionList);

    int insertSelective(SessionList sessionList);

    @Select("select * from session_list where id = #{id}")
    SessionList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SessionList sessionList);

    int updateByPrimaryKey(SessionList sessionList);

    @Select("SELECT to_user_id FROM session_list WHERE user_id = #{id}")
    List<String> selectUserIdByUserId(String id);

    @Select("SELECT * FROM session_list WHERE user_id = #{id}")
    List<SessionList> selectByUserId(String id);

    @Select("SELECT id FROM session_list WHERE user_id = #{fromId} AND to_user_id = #{toId}")
    Integer selectIdByUser(@Param("fromId") String fromId, @Param("toId") String toId);

    @Select("SELECT id FROM session_list WHERE user_id = #{fromId} AND to_user_id = #{toId} AND list_name = #{listName}")
    SessionList selectSessionId(@Param("fromId") String fromId, @Param("toId") String toId,@Param("listName") String listName);

    @Update("UPDATE session_list SET un_read_count = un_read_count + 1 WHERE user_id = #{userId} AND to_user_id = #{toUserId}")
    void addUnReadCount(@Param("userId") String userId, @Param("toUserId") String toUserId);

    @Delete("UPDATE session_list SET un_read_count = 0 WHERE user_id = #{fromUserId} AND to_user_id = #{toUserId}")
    void delUnReadCount(@Param("fromUserId") String fromUserId, @Param("toUserId") String toUserId);
}
