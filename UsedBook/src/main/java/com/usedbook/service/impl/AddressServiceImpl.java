package com.usedbook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usedbook.mapper.AddressMapper;
import com.usedbook.pojo.Address;
import com.usedbook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;
    @Override
    public List<Address> getByUserId(String aUserId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("a_user_id",aUserId);
        List list = addressMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.insert(address);
    }
}
