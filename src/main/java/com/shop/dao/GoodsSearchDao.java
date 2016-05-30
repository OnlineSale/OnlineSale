package com.shop.dao;

import com.shop.model.Good;
import com.shop.model.GoodsSearchInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuan on 16-5-14.
 */
public interface GoodsSearchDao {
    public List<Good> getGoodsByKeyWords(GoodsSearchInfo goodsSearchInfo);

    /**
     * 根据小类id返回一定数量的Good信息
     * @param subCategoryId 小类id
     * @param offset 偏移量
     * @param size 返回的最大数量
     * @return
     */
    public List<Good> getGoodBySubCategoryId(@Param("subCategoryId")Integer subCategoryId, @Param("offset")Integer offset, @Param("size")Integer size);
}
