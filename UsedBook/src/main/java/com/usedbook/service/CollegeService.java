package com.usedbook.service;

import com.usedbook.pojo.College;

import java.util.List;

public interface CollegeService {
    int insert(College college);

    List<College> selectById();

    void delete(String cId);

    int update(College college);
}
