package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.MsgInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgInfoMapper extends BaseMapper<MsgInfo> {

    int deleteByPrimaryKey(Integer id);

    @Insert("insert into msg_info (id,from_user_id,from_user_name,to_user_id, to_user_name, content, create_time,un_read_flag) values(#{id},#{fromUserId},#{fromUserName},#{toUserId},#{toUserName},#{content},#{createTime,jdbcType=TIMESTAMP},#{unReadFlag})")
    int inserts(MsgInfo msgInfo);

    int insertSelective(MsgInfo msgInfo);

    MsgInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgInfo msgInfo);

    int updateByPrimaryKey(MsgInfo msgInfo);

    List<MsgInfo> select(MsgInfo msgInfo);
    @Update("UPDATE msg_info SET un_read_flag = 1 WHERE from_user_id = #{fromUserId} AND to_user_id = #{toUserId}")
    void msgRead(@Param("fromUserId") String fromUserId, @Param("toUserId") String toUserId);

    @Select("SELECT * FROM msg_info WHERE ((to_user_id = #{toUserId} AND from_user_id = #{fromUserId}) OR (to_user_id = #{fromUserId} AND from_user_id = #{toUserId}))")
    List<MsgInfo> selectMsgList(@Param("fromUserId") String fromUserId, @Param("toUserId") String toUserId);
}
