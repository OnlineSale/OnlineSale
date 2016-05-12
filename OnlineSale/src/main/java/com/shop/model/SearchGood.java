package com.shop.model;

/**
 * Created by wqlin on 16-5-7.
 */
public class SearchGood {
    private  Integer goodID;
    private Integer subCategoryId;
    private String goodName;
    private Double price;
    private Integer stoke;
    private String brand;
    private String goodImage;
    private Integer goodPoint;

    public Integer getGoodID(){return goodID;}
    public void setGoodID(Integer goodID){this.goodID=goodID;}

    public Integer getSubCategoryId(){return subCategoryId;}
    public void setSubCategoryId(Integer subCategoryId){
        this.subCategoryId=subCategoryId;
    }

    public String getgoodName(){return goodName;}
    public void setgoodName(String goodName){
        this.goodName=goodName;
    }

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price=price;}

    public Integer getStoke(){return stoke;}
    public void setStoke(Integer stoke){this.stoke=stoke;}

    public String getBrand(){return brand;}
    public void setBrand(String brand){this.brand=brand;}

    public String getGoodImage(){return goodImage;}
    public void  setGoodImage(String goodImage){this.goodImage=goodImage;}

    public Integer getGoodPoint(){return goodPoint;}
    public void setGoodPoint(Integer goodPoint){
        this.goodPoint=goodPoint;
    }



}
