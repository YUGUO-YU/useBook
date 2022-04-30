package com.usedbook.controller;

import com.alibaba.fastjson.JSONObject;
import com.usedbook.pojo.Address;
import com.usedbook.service.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    /**
     * 通过id查询地址
     * @param userId
     * @return
     */
    @GetMapping(value = "/getAddress", produces = "application/json")
    @ApiOperation("查询地址")
    public JSONObject getByUserIdAddress(@PathParam(value = "userId")String userId){
        List<Address> byUserId = addressService.getByUserId(userId);
        JSONObject ret = new JSONObject();
        ret.put("code",0);
        ret.put("data",byUserId);
        ret.put("msg","查询成功");
        return ret;
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ApiOperation("新增地址")
    public JSONObject addAddress(@RequestBody Address address){
        JSONObject ret = new JSONObject();
        int i = addressService.addAddress(address);
        if (i > 0) {
            ret.put("code", 0);
            ret.put("data", true);
            ret.put("msg", "增加成功");
        } else {
            ret.put("code", -1);
            ret.put("data", false);
            ret.put("msg", "增加失败");
        }
        return ret;
    }
}
