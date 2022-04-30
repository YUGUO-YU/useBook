package com.usedbook.service.impl;

import com.usedbook.mapper.CodeMapper;
import com.usedbook.pojo.Code;
import com.usedbook.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CodeServiceImp implements CodeService {
    @Autowired
    CodeMapper codeMapper;
    @Override
    public int insert(Code code1) {
        return codeMapper.insert(code1);
    }

    @Override
    public Code selectById(String id) {
        return codeMapper.selectById(id);
    }

    @Override
    public void delete(String id) {
        codeMapper.deleteById(id);
    }

    @Override
    public int update(Code code) {
        return codeMapper.updateById(code);
    }
}
