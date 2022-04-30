package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zining
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from f_order where product_id = #{productId}")
    Order getByProductIdToAddressId(@Param(value = "productId")String productId);
}
