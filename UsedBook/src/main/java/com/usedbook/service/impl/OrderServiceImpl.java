package com.usedbook.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usedbook.mapper.AddressMapper;
import com.usedbook.mapper.OrderMapper;
import com.usedbook.mapper.ProductMapper;
import com.usedbook.pojo.Address;
import com.usedbook.pojo.MyOrder;
import com.usedbook.pojo.Order;
import com.usedbook.pojo.Product;
import com.usedbook.service.OrderService;
import com.usedbook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zining
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductService productService;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public int addOrder(Order order) {
        int insert = orderMapper.insert(order);
        String productId = order.getProductId();
        productMapper.updateByproId(productId);
        return insert;
    }

    @Override
    public List<Order> getByAddressId(int addressId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("address_id",addressId);
        List list = orderMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public List<MyOrder> getByUserId(String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        List<Order> list = orderMapper.selectList(queryWrapper);
        ArrayList<MyOrder> lists = new ArrayList<>();
        for (Order order : list) {
            MyOrder myOrder = new MyOrder();
            myOrder.setId(order.getId());
            myOrder.setOrderNo(order.getOrderNo());
            myOrder.setRealFee(order.getRealFee());
            myOrder.setCreateTime(order.getPayTime());
            myOrder.setAddressId(order.getAddressId());
            Product byProductId = productService.getByProductId(order.getProductId());
            Address byOrderId = addressMapper.getByOrderId(order.getAddressId());
            myOrder.setAddress(byOrderId.getaAddress());
            myOrder.setTitle(byProductId.getTitle());
            myOrder.setContent(byProductId.getContent());
            myOrder.setImgUrl(byProductId.getImgUrl());
            lists.add(myOrder);
        }
        return lists;
    }

    @Override
    public List<MyOrder> getByUserIdToOrder(String userId, int isNot) {
        List<Product> byUserIdToOrder = productMapper.getByUserIdToOrder(userId, isNot);
        ArrayList<MyOrder> lists = new ArrayList<>();
        for (Product product : byUserIdToOrder) {
            MyOrder myOrder = new MyOrder();
            Order byProductIdToAddressId = orderMapper.getByProductIdToAddressId(product.getId());
            Address byOrderId = addressMapper.getByOrderId(byProductIdToAddressId.getAddressId());
            myOrder.setId(byProductIdToAddressId.getId());
            myOrder.setOrderNo(byProductIdToAddressId.getOrderNo());
            myOrder.setRealFee(byProductIdToAddressId.getRealFee());
            myOrder.setCreateTime(byProductIdToAddressId.getPayTime());
            myOrder.setAddressId(byProductIdToAddressId.getAddressId());
            myOrder.setAddress(byOrderId.getaAddress());
            myOrder.setTitle(product.getTitle());
            myOrder.setContent(product.getContent());
            myOrder.setImgUrl(product.getImgUrl());
            lists.add(myOrder);
        }
        return lists;
    }
}