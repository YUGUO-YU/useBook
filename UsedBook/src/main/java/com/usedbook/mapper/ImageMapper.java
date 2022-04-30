package com.usedbook.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zining
 */
@Repository
public interface ImageMapper extends BaseMapper<Image> {
}
