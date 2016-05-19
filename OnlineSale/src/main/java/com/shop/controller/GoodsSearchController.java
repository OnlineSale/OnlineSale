package com.shop.controller;

import com.shop.model.GoodsSearchInfo;
import com.shop.service.GoodsSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

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
}
