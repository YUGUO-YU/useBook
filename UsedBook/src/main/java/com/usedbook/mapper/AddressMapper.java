package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMapper extends BaseMapper<Address> {
    @Select("select * from address where a_id = #{addressId}")
    Address getByOrderId(@Param(value = "addressId")int addressId);
}
