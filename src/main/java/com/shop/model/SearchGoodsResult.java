package com.shop.model;

import java.util.List;
/**
 * Created by wqlin on 16-5-7.
 * 商品搜索用到的model
 */
public class SearchGoodsResult {
    /**
     * "code":0表示输入非法
     * "code":1表示查询结果成功
     * "code":2 表示查询结果为空
     */
    int code=2;
    List<SearchGoodsResult> goodResult=null;

    public int getCode(){return code;}
    public void setCode(int code){this.code=code;}

//    public List<SearchGoodsJson> getGoodResult(){return goodResult;}
//    public void setGoodResult(List<SearchGoodsJson> goodResult){
//        this.goodResult=goodResult;
//    }
}
