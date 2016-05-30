package com.shop.dao;

import com.shop.model.Category;
import com.shop.model.SubCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuan on 16-5-29.
 */
public interface CategoryDao {
    /**
     * 根据大类id返回大类的信息
     * @param categoryId
     * @return
     */
    public Category getBigCategoryById(@Param("categoryId") Integer categoryId);

    /**
     * 返回所有大类信息
     * @param offset 偏移量
     * @param size 返回的最大数量
     * @return
     */
    public List<Category> getAllBigCategory(@Param("offset")Integer offset,@Param("size")Integer size);

    /**
     * 返回所有小类信息
     * @param offset 偏移量
     * @param size 返回的最大数量
     * @return
     */
    public List<SubCategory> getAllSubCategory(@Param("offset")Integer offset,@Param("size")Integer size);

    /**
     * 根据大类ID返回属于该大类的所有小类
     * @param bigCategoryId 大类的ID
     * @return
     */
    public List<SubCategory> getSubCategoryByBigCategoryId(@Param("bigCategoryId")Integer bigCategoryId);

    /**
     * 根据小类id返回一个小类的信息
     * @param subCategoryId 小类的id
     * @return
     */
    public SubCategory getSubCategoryBySubCategoryId(@Param("subCategoryId")Integer subCategoryId);
}
