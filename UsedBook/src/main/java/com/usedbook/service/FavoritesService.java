package com.usedbook.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedbook.pojo.Favorites;
import com.usedbook.pojo.User;

import java.util.List;

/**
 * 产品收藏表
 *
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
public interface FavoritesService{

    Page<Favorites>  selectListPage(User user);

    Integer addFavorites(Favorites favorites);
    Integer deleteFavorites(String fid);
    List<Favorites> selectByUid(String uId);
}

