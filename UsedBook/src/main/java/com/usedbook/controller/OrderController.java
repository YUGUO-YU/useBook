package com.usedbook.controller;

import com.alibaba.fastjson.JSONObject;
import com.usedbook.pojo.MyOrder;
import com.usedbook.pojo.Order;
import com.usedbook.service.OrderService;
import com.usedbook.utils.StringTool;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;


/**
 * 订单表
 *
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/addorder", produces = "application/json")
    @ApiOperation("新增订单")
    public JSONObject addOrder(@RequestBody JSONObject par){
        JSONObject ret = new JSONObject();
        System.out.println(par.get("order"));
        par.get("order");
        Order order = new Order();
        order.setUserId(par.getString("userId"));
        order.setProductId(par.getString("productId"));
        order.setAddressId(par.getIntValue("addressId"));
        order.setRealFee(par.getDouble("realFee"));
        order.setOrderNo(StringTool.getUUID());
        order.setPayTime(new Date());
        int ord =orderService.addOrder(order);
        if (ord==0){
            ret.put("code", -1);
            ret.put("msg", "新增失败");
            return ret;
        }else {
            ret.put("code", 0);
            ret.put("msg", "新增成功");
        }
        return ret;
    }

    /**
     * 我买到的
     * @param userId
     * @return
     */
    @GetMapping(value = "/getByUserIdOrder", produces = "application/json")
    @ApiOperation("查询订单")
    public JSONObject getByUserId(@PathParam(value = "userId")String userId){
        JSONObject ret = new JSONObject();
        List<MyOrder> byUserId = orderService.getByUserId(userId);
        ret.put("data",byUserId);
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        return ret;
    }

    /**
     * 我卖出的
     * @param userId
     * @param isNot
     * @return
     */
    @GetMapping(value = "/getByUserIdToOrder", produces = "application/json")
    @ApiOperation("查询卖出订单")
    public JSONObject getByUserIdToOrder(@PathParam(value = "userId")String userId,@PathParam(value = "isNot")int isNot){
        System.out.println(userId);
        JSONObject ret = new JSONObject();
        List<MyOrder> byUserIdToOrder = orderService.getByUserIdToOrder(userId, isNot);
        ret.put("data",byUserIdToOrder);
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        return ret;
    }
}
