package com.usedbook.service.impl;


import com.usedbook.mapper.ImageMapper;
import com.usedbook.pojo.Image;
import com.usedbook.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zining
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;
    @Override
    public int insert(Image image) {
        return imageMapper.insert(image);
    }
}