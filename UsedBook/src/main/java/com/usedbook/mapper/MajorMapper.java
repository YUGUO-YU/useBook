package com.usedbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.Major;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorMapper extends BaseMapper<Major> {
    @Select("select * from major where m_father_id = #{mFatherId}")
    List<Major> getAllMajor(int mFatherId);
}
