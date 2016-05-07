package com.shop.util;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqlin on 16-5-7.
 */
public class SplitWrods {
    /**
     * 使用ansjseg库把传递进来的字符串进行分词，保留名词
     * @param sentence句子
     * @retrun 返回一个包含名词的对象数组
     */

    public static Object[] DivideSentenceIntoNoun(String sentence){
        List<String> keywords=new ArrayList<~>();
        List<Term> parse=ToAnalysis.parse(sentence);
        for(Term term:parse){
            if(term.getNatureStr().equals("n")||term.getNatureStr().equals("en")){
                s=term.getName();
                keywords.add(s);
            }
            return keywords.toArray();
        }
    }
}
