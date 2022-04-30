package com.usedbook.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.usedbook.mapper.UserMapper;
import com.usedbook.pojo.User;
import com.usedbook.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author zining
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User qureyByUserName(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User qureyByEmail(String email) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("email",email);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public int update(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("user_name",user.getUserName());
        return userMapper.update(user,updateWrapper);
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectByIds(Object[] id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("id",id);
        return userMapper.selectList(queryWrapper);
    }
}