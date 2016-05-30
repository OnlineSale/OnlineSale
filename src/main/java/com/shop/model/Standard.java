package com.shop.model;

public class Standard {
    private Integer standardid;

    private Integer specificationid;

    private String standardname;

    private Double price;

    private Integer stoke;

    public Integer getStandardid() {
        return standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    public Integer getSpecificationid() {
        return specificationid;
    }

    public void setSpecificationid(Integer specificationid) {
        this.specificationid = specificationid;
    }

    public String getStandardname() {
        return standardname;
    }

    public void setStandardname(String standardname) {
        this.standardname = standardname == null ? null : standardname.trim();
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