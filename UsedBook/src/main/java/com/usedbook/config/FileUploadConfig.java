package com.usedbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileUploadConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径
        String path = "file:"+System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\";
        //static/upload/**是对应resource下工程目录
        System.out.println("我是"+path);
        registry.addResourceHandler("/images/**").addResourceLocations(path);

    }
}


