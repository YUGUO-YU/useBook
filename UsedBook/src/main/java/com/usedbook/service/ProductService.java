package com.usedbook.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedbook.pojo.Product;

import java.util.Map;

/**
 * 商品表
 *
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
public interface ProductService{

    Page selectListAllPage(Map<String, Object> map);

    Page selectListPage(Map<String, Object> map);

    Page selectListPageByUser(Map<String, Object> map);

    Page selectListsPageById(Map<String, Object> map);

    Page getBycIdAllPro(Map<String, Object> map);

    Page getBycIdmIdAllPro(Map<String, Object> map);

    Page getBymIdgIdAllPro(Map<String, Object> map);

    Page getBygIdAllPro(Map<String, Object> map);

    int insert(Product product);

    int update(Product product);

    int updateById(String dbId, boolean sta);

    Product selectById(String dbId);

    int updateIncrease(Product product);

    int delete(String id, String pId);

    Product getByProductId(String ProductId);
}

