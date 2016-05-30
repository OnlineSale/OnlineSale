package com.shop.controller;

import com.shop.model.Good;
import com.shop.model.GoodsSearchInfo;
import com.shop.model.Result;
import com.shop.service.GoodsSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by yuan on 16-5-15.
 */
@Controller
@RequestMapping("/search")
public class GoodsSearchController {

    @Resource
    GoodsSearchService goodsSearchService;

    @RequestMapping("/goodsByKeyWords")
    @ResponseBody
    public Object searchGoodsByKeyWords(@Valid GoodsSearchInfo goodsSearchInfo, BindingResult bindingResult){
        return goodsSearchService.searchGoodsByKeyWords(goodsSearchInfo,bindingResult);
    }


    /**
     * 根据小类id返回一定数量的商品信息
     * @param subCategoryId 小类id
     * @param page 页数(page>0)
     * @param size 每一页能够包含的最大数量 (size>0)
     * @return
     */
    @RequestMapping("/goodsBySubCategoryId")
    @ResponseBody
    public Object searchGoodsBySubCategoryId(@RequestParam("subCategoryId") Integer subCategoryId, @RequestParam("page") Integer page, @RequestParam("size") Integer size){
        Result result=new Result();
        List<Good> goods=goodsSearchService.searchGoodsBySubCategoryId(subCategoryId,page,size);
        result.setData(goods);
        result.setStatusSuccess();
        return result;
    }


}
