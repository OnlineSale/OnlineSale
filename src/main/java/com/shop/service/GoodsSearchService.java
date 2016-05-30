package com.shop.service;

import com.shop.model.Good;
import com.shop.model.GoodsSearchInfo;
import org.springframework.validation.BindingResult;

import java.util.List;

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

    /**
     * 根据小类id返回一定数量的商品信息
     * @param subCategoryId 小类id
     * @param page 页数(page>0)
     * @param size 每一页能够包含的最大数量 (size>0)
     * @return
     */
    public List<Good> searchGoodsBySubCategoryId(Integer subCategoryId, Integer page, Integer size);
}
