package com.shop.model;

public class Good {
    private Integer goodid;

    private Integer classid;

    private String goodname;

    private Double price;

    private Integer stoke;

    private String gooddesc;

    private String brand;

    private String goodlable;

    private Integer sales;

    private Integer clicks;

    private Double goodpoint;

    private Double serverpoint;

    private Double logisticspoint;

    private String goodimage;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
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

    public String getGooddesc() {
        return gooddesc;
    }

    public void setGooddesc(String gooddesc) {
        this.gooddesc = gooddesc == null ? null : gooddesc.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getGoodlable() {
        return goodlable;
    }

    public void setGoodlable(String goodlable) {
        this.goodlable = goodlable == null ? null : goodlable.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Double getGoodpoint() {
        return goodpoint;
    }

    public void setGoodpoint(Double goodpoint) {
        this.goodpoint = goodpoint;
    }

    public Double getServerpoint() {
        return serverpoint;
    }

    public void setServerpoint(Double serverpoint) {
        this.serverpoint = serverpoint;
    }

    public Double getLogisticspoint() {
        return logisticspoint;
    }

    public void setLogisticspoint(Double logisticspoint) {
        this.logisticspoint = logisticspoint;
    }

    public String getGoodimage() {
        return goodimage;
    }

    public void setGoodimage(String goodimage) {
        this.goodimage = goodimage == null ? null : goodimage.trim();
    }
}