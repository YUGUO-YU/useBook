package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.Code;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeMapper extends BaseMapper<Code> {
}
