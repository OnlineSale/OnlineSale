package com.shop.service.imp;

import com.shop.dao.GoodsSearchDao;
import com.shop.model.Good;
import com.shop.model.GoodsSearchInfo;
import com.shop.service.GoodsSearchService;
import com.shop.util.SplitWrods;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yuan on 16-5-14.
 */
@Service
public class GoodsSearchServiceImpl implements GoodsSearchService{
    private final static String KEY_STATUS="status";
    private final static String KEY_ERRORS="errors";
    private final static String KEY_GOODS="goods";

    private final static String STATUS_SUCCESS="success";
    private final static String STATUS_FAIL="fail";
    private final static String ERRORS_EMPTY="搜索结果为空";


    @Resource
    GoodsSearchDao goodsSearchDao;

    public Object searchGoodsByKeyWords(GoodsSearchInfo goodsSearchInfo, BindingResult bindingResult) {
        Map<String,Object> result=new HashMap<String, Object>();
        List<String> keywords=SplitWrods.DivideStringIntoNoun(goodsSearchInfo.getSearchContent());
        goodsSearchInfo.setKeywords(keywords);
        int page=goodsSearchInfo.getPage();
        int size=goodsSearchInfo.getSize();
        int offset=(page-1)*size;
        goodsSearchInfo.setOffset(offset);
        List<Good> goods=goodsSearchDao.getGoodsByKeyWords(goodsSearchInfo);
        if(goods==null||goods.isEmpty()){
            result.put(KEY_STATUS,STATUS_FAIL);
            result.put(KEY_ERRORS,ERRORS_EMPTY);
            return result;
        }
        setConformityForEveryGood(goods,keywords);
        Collections.sort(goods,new GoodComparator());
        result.put(KEY_STATUS,STATUS_SUCCESS);
        result.put(KEY_GOODS,goods);
        return result;
    }

    /**
     * 为搜索到的每个商品设置符合度
     * @param goods
     * @param keywords
     */
    private void setConformityForEveryGood(List<Good> goods,List<String> keywords) {
        for(int i=0;i<keywords.size();i++){
            String keyword=keywords.get(i);
            keywords.set(i,keyword.substring(1,keyword.length()-1));
        }
        String goodName=null;
        String goodLable=null;
        int conformity=0;
        for(Good good:goods){
            conformity=0;
            goodName=good.getGoodname();
            goodLable=good.getGoodlable();
            if(goodLable==null)
                goodLable="";
            for(String keyword:keywords){
                if(goodName.contains(keyword))
                    conformity++;
                if(goodLable.contains(keyword))
                    conformity++;
            }
            good.setConformity(conformity);
        }
    }
}


/**
 * 根据商品的符合度进行排序(降序)
 */
class GoodComparator implements Comparator<Good>{

    public int compare(Good good1, Good good2) {
        int conformity1=good1.getConformity();
        int conformity2=good2.getConformity();
        return conformity1>=conformity2?-1:1;
    }
}
