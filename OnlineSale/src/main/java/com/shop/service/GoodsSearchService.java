package com.shop.service;

import com.shop.model.GoodsSearchInfo;
import org.springframework.validation.BindingResult;

/**
 * Created by yuan on 16-5-14.
 */
public interface GoodsSearchService {

    /**
     * 根据搜索内容的关键字来搜索商品并且按照相关度由高到低排序
     * @param goodsSearchInfo
     * @return
     */
    public Object searchGoodsByKeyWords(GoodsSearchInfo goodsSearchInfo, BindingResult bindingResult);
}
