package com.usedbook.service.impl;

import com.usedbook.mapper.MsgInfoMapper;
import com.usedbook.pojo.MsgInfo;
import com.usedbook.service.MsgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgInfoServiceImpl implements MsgInfoService {
    @Autowired
    MsgInfoMapper msgInfoMapper;

    @Override
    public int inserts(MsgInfo msgInfo) {
        return msgInfoMapper.insert(msgInfo);
    }
}
