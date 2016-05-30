package com.shop.model;

import java.util.HashMap;

/**
 * Created by yuan on 16-5-28.
 */
public class Result extends HashMap<String,Object>{
    public static final String KEY_STATUS="status";
    public static final String KEY_DATA="data";
    public static final String KEY_ERROR="error";
    public static final Integer STATUS_SUCCESS=1;
    public static final Integer STATUS_FAIL=0;
    public Result(){
        this.put(KEY_STATUS,KEY_ERROR);
//        this.put(KEY_DATA,null);
        this.put(KEY_ERROR,"");
    }
    public void setData(Object data){
        this.put(KEY_DATA,data);
    }
    public void setStatus(Integer status){
        this.put(KEY_STATUS,status);
    }
    public void setError(Object error){
        this.put(KEY_ERROR,error);
    }
    public void setStatusSuccess(){
        this.setStatus(STATUS_SUCCESS);
    }
    public void setStatusFail(){
        this.setStatus(STATUS_FAIL);
    }
}
