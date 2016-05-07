package com.shop.service;

import com.shop.model.SearchGoodsResult;

/**
 * Created by wqlin on 16-5-7.
 * 分页返回搜索内容
 * searchContent是搜索的关键词
 * page返回的页面数
 * pageSize返回的是页面大小
 */
public interface SerarchGoodsService {
    public SearchGoodsResult searchGoods(String searchContent,String page,String pageSize);
}
