package com.usedbook.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usedbook.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zining
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
    @Update("update f_product set is_not = 1 where id = #{productId}")
    int updateByproId(String productId);

    @Select("select * from f_product where id = #{ProductId}")
    Product getByProductId(String ProductId);

    @Select("select * from f_product where user_id=#{userId} and is_not=#{isNot}")
    List<Product> getByUserIdToOrder(@Param(value = "userId") String userId, @Param(value = "isNot") int isNot);
}
