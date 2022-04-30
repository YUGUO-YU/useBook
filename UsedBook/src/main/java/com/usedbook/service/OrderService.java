package com.usedbook.service;

import com.usedbook.pojo.MyOrder;
import com.usedbook.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单表
 *
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
public interface OrderService{
    int addOrder(Order order);
    List<Order> getByAddressId(int addressId);
    List<MyOrder> getByUserId(String userId);
    List<MyOrder> getByUserIdToOrder(@Param(value = "userId") String userId,@Param(value = "isNot") int isNot);
}

