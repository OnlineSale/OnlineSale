package com.shop.model;

public class Specification {
    private Integer specificationid;

    private Integer goodid;

    private String specificationname;

    private String specificationimage;

    private Double price;

    private Integer stoke;

    public Integer getSpecificationid() {
        return specificationid;
    }

    public void setSpecificationid(Integer specificationid) {
        this.specificationid = specificationid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getSpecificationname() {
        return specificationname;
    }

    public void setSpecificationname(String specificationname) {
        this.specificationname = specificationname == null ? null : specificationname.trim();
    }

    public String getSpecificationimage() {
        return specificationimage;
    }

    public void setSpecificationimage(String specificationimage) {
        this.specificationimage = specificationimage == null ? null : specificationimage.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStoke() {
        return stoke;
    }

    public void setStoke(Integer stoke) {
        this.stoke = stoke;
    }
}