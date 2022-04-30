package com.usedbook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedbook.mapper.FavoritesMapper;
import com.usedbook.pojo.Favorites;
import com.usedbook.pojo.User;
import com.usedbook.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zining
 */
@Service
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    FavoritesMapper favoritesMapper;

    @Override
    public Page<Favorites> selectListPage(User user) {
        Page<Favorites> favoritesPage = new Page<>(user.getPage(), user.getNumber());
        QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        favoritesMapper.selectPage(favoritesPage, queryWrapper);
        return favoritesPage;
    }

    @Override
    public Integer addFavorites(Favorites favorites) {
        return favoritesMapper.insert(favorites);
    }

    @Override
    public Integer deleteFavorites(String fid) {
        return favoritesMapper.deleteById(fid);
    }

    @Override
    public List<Favorites> selectByUid(String uId) {
        QueryWrapper<Favorites> favoritesServiceQueryWrapper = new QueryWrapper<>();
        favoritesServiceQueryWrapper.eq("user_id", uId);
        return favoritesMapper.selectList(favoritesServiceQueryWrapper);
    }


}