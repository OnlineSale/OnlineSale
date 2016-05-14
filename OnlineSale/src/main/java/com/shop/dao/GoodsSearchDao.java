package com.shop.dao;

import com.shop.model.Good;
import com.shop.model.GoodsSearchInfo;

import java.util.List;

/**
 * Created by yuan on 16-5-14.
 */
public interface GoodsSearchDao {
    public List<Good> getGoodsByKeyWords(GoodsSearchInfo goodsSearchInfo);
}
