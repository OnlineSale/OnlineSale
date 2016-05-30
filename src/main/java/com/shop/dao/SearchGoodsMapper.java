package com.shop.dao;

import com.shop.model.SearchGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wqlin on 16-5-7.
 */
public interface SearchGoodsMapper {
    public List<SearchGood> selectByKeyWordInTitle(@Param("keywords") Object[] keywords);

}
