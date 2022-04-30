package com.usedbook.service.impl;

import com.usedbook.mapper.CollegeMapper;
import com.usedbook.pojo.College;
import com.usedbook.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    CollegeMapper collegeMapper;
    @Override
    public int insert(College college) {
        return 0;
    }

    @Override
    public List<College> selectById() {
        return collegeMapper.getAllList();
    }

    @Override
    public void delete(String cId) {

    }

    @Override
    public int update(College college) {
        return 0;
    }
}
