package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zining
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> getCloudList(@Param("list") List<String> list);

    @Select("select * from f_user where id = #{userId}")
    User selectById(String userId);
}
