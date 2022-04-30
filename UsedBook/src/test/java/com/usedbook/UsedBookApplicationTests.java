package com.usedbook;

import com.usedbook.pojo.MyOrder;
import com.usedbook.service.OrderService;
import com.usedbook.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsedBookApplicationTests {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Test
    void contextLoads() {
        String userId = "c0be8e3ed567438897076db6a18ae418";
        List<MyOrder> list =orderService.getByUserId(userId);
    }

}
