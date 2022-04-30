package com.usedbook.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedbook.mapper.ProductMapper;
import com.usedbook.pojo.Product;
import com.usedbook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


/**
 * @author zining
 */
@Service("fProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public Page selectListAllPage(Map<String, Object> map) {
        int page = (int) map.get("page");
        int number = (int) map.get("number");
        Page<Product> productPage = new Page<Product>(page, number);
        QueryWrapper queryWrapperss = new QueryWrapper();
        queryWrapperss.eq("is_show", 1);
        queryWrapperss.eq("is_del", 0);
        queryWrapperss.eq("is_not",0);

        productMapper.selectPage(productPage,queryWrapperss);
        return productPage;
    }

    @Override
    public Page selectListPage(Map<String, Object> map) {
        Long page = (Long) map.get("page");
        Long number = (Long) map.get("number");
        String key = (String) map.get("key");
        Page<Product> productPage = new Page<Product>(page, number);
        if (key != null) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("is_show", 1);
            queryWrapper.eq("is_del", 0);
            queryWrapper.eq("is_not",0);
            queryWrapper.like("title", key);
            IPage iPage = productMapper.selectPage(productPage, queryWrapper);
            if (iPage.getRecords().size()==0){
                    QueryWrapper queryWrappers = new QueryWrapper();
                    queryWrappers.eq("is_show", 1);
                    queryWrappers.eq("is_del", 0);
                    queryWrappers.eq("is_not",0);
                    queryWrappers.like("content", key);

                productMapper.selectPage(productPage,queryWrappers);
                System.out.println(iPage.getRecords().size());
            }
        }else {
            QueryWrapper queryWrapperss = new QueryWrapper();
            queryWrapperss.eq("is_show", 1);
            queryWrapperss.eq("is_del", 0);
            queryWrapperss.eq("is_not",0);

            productMapper.selectPage(productPage,queryWrapperss);
        }
        return productPage;
    }

    @Override
    public Page selectListPageByUser(Map<String, Object> map) {
        Long page = (Long) map.get("page");
        Long number = (Long) map.get("number");
        String userId = (String) map.get("userId");
        Page<Product> productPage = new Page<Product>(page, number);
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("is_show", 1);
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq("is_not",0);
        queryWrapper.eq("user_id",userId);
        productMapper.selectPage(productPage,queryWrapper);
        return productPage;
    }
    @Override
    public Page selectListsPageById(Map<String, Object> map) {
        Long page = (Long) map.get("page");
        Long number = (Long) map.get("number");
        Object[] ids = (Object[]) map.get("pId");
        Page<Product> productPage = new Page<Product>(page, number);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_show", 1);
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq("is_not",0);
        queryWrapper.in("id",ids);
        productMapper.selectPage(productPage,queryWrapper);
        return productPage;
    }

    @Override
    public Page getBycIdAllPro(Map<String, Object> map) {
        int page = (int) map.get("page");
        int number = (int) map.get("number");
        int cId = (int) map.get("cId");
        Long p = new Long((long)page);
        Long n = new Long((long)number);
        Page<Product> productPage = new Page<Product>(p, n);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_show", 1);
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq("is_not",0);
        queryWrapper.eq("college_id",cId);
        productMapper.selectPage(productPage,queryWrapper);
        return productPage;
    }

    @Override
    public Page getBycIdmIdAllPro(Map<String, Object> map) {
        int page = (int) map.get("page");
        int number = (int) map.get("number");
        int cId = (int) map.get("cId");
        int mId = (int) map.get("mId");
        Long p = new Long((long)page);
        Long n = new Long((long)number);
        Page<Product> productPage = new Page<Product>(p, n);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_show", 1);
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq("is_not",0);
        queryWrapper.eq("college_id",cId);
        queryWrapper.eq("major_id",mId);
        productMapper.selectPage(productPage,queryWrapper);
        return productPage;
    }

    @Override
    public Page getBymIdgIdAllPro(Map<String, Object> map) {
        int page = (int) map.get("page");
        int number = (int) map.get("number");
        int mId = (int) map.get("mId");
        int gId = (int) map.get("gId");
        Long p = new Long((long)page);
        Long n = new Long((long)number);
        Page<Product> productPage = new Page<Product>(p, n);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_show", 1);
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq("is_not",0);
        queryWrapper.eq("major_id",mId);
        queryWrapper.eq("grade_id",gId);
        productMapper.selectPage(productPage,queryWrapper);
        return productPage;
    }

    @Override
    public Page getBygIdAllPro(Map<String, Object> map) {
        int page = (int) map.get("page");
        int number = (int) map.get("number");
        int gId = (int) map.get("gId");
        Long p = new Long((long)page);
        Long n = new Long((long)number);
        Page<Product> productPage = new Page<Product>(p, n);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_show", 1);
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq("is_not",0);
        queryWrapper.eq("grade_id",gId);
        productMapper.selectPage(productPage,queryWrapper);
        return productPage;
    }

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", product.getId());
        return productMapper.update(product, updateWrapper);
    }

    @Override
    public int updateById(String dbId, boolean sta) {
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", dbId);
        Product product = new Product();
        if (sta) {
            product.setIsShow(0);
        } else {
            product.setIsShow(1);
        }
        product.setCreateTime(new Date());
        return productMapper.update(product, updateWrapper);
    }

    @Override
    public Product selectById(String dbId) {
        return productMapper.selectById(dbId);
    }

    @Override
    public int updateIncrease(Product product) {
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", product.getId());
        product.setCount(product.getCount()+1);
        return productMapper.update(product,updateWrapper);
    }

    @Override
    public int delete(String uid, String pId) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id",pId);
        updateWrapper.eq("user_id",uid);
        Product product = new Product();
        product.setIsDel(1);
        product.setCreateTime(new Date());
        return productMapper.update(product,updateWrapper);
    }

    @Override
    public Product getByProductId(String ProductId) {
        Product product =productMapper.getByProductId(ProductId);
        return product;
    }

}