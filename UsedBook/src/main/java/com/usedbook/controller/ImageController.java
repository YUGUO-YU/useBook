package com.usedbook.controller;

import com.alibaba.fastjson.JSONObject;
import com.usedbook.common.R;
import com.usedbook.config.PathConfig;
import com.usedbook.pojo.Image;
import com.usedbook.service.ImageService;
import com.usedbook.utils.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


/**
 * 图片表
 *
 * @author zining
 * @date 2019-11-12 10:46:22
 */
@RestController
@RequestMapping("/image")
@Api("图片接口")
@CrossOrigin
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    private PathConfig pathConfig;


    /**
     * 上传img
     *
     * @param file 文件
     * @return {@link JSONObject}
     */
    @SneakyThrows
    @PostMapping("/uploadImg")
    @ApiOperation("图片上传")
    public R<String> uploadImg(MultipartFile file) throws IOException {
        JSONObject ret = new JSONObject();
        String fileName = file.getOriginalFilename();
        String newFileName = StringTool.getUUID() + Objects.requireNonNull(fileName).substring(fileName.indexOf("."));
        System.out.println("地址："+newFileName);
        Image image = new Image();
        File file1;
// 保存路径方法1
//        String os = System.getProperty("os.name");
//        if (os.toLowerCase().startsWith("win")) {
//            file1 = new File(pathConfig.getWinPath(), newFileName);
//        } else {
//            file1 = new File(pathConfig.getWinPath(), newFileName);
//        }
// 路径方法2
        //设置编译后文件存在路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\images\\";
        //ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\"+图片名

        //获取项目路径
        File directory = new File("src/main/resources/static/images/");
        String paths = directory.getCanonicalPath();
        System.out.println("1"+path);
        System.out.println("2"+paths);
        file1 = new File(paths+'/' + newFileName);

        if (!file1.exists()) {
            System.out.println(file1.mkdir());
        }
        file.transferTo(file1);
        image.setId(StringTool.getUUID());
        image.setImgUrl(newFileName);
        imageService.insert(image);
        System.out.println(file1.toString());
        //return R.ok(0,"图片上传成功", file1.toString());
        return R.ok(0,"图片上传成功", "images/" + image.getImgUrl());
    }
}
