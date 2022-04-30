package com.usedbook.service.impl;

import com.usedbook.mapper.MajorMapper;
import com.usedbook.pojo.Major;
import com.usedbook.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorMapper majorMapper;
    @Override
    public List<Major> getAllMajor(int mFatherId) {
        return majorMapper.getAllMajor(mFatherId);
    }
}
