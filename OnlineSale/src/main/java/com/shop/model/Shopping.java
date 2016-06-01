package com.shop.model;

public class Shopping {
    private Integer shoppingid;

    private Integer userid;

    private Integer goodid;

    private Integer goodnumber;

    private String shoptime;

    private String goodname;

    public Integer getShoppingid() {
        return shoppingid;
    }

    public void setShoppingid(Integer shoppingid) {
        this.shoppingid = shoppingid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getGoodnumber() {
        return goodnumber;
    }

    public void setGoodnumber(Integer goodnumber) {
        this.goodnumber = goodnumber;
    }

    public String getShoptime() {
        return shoptime;
    }

    public void setShoptime(String shoptime) {
        this.shoptime = shoptime == null ? null : shoptime.trim();
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "shoppingid=" + shoppingid +
                ", userid=" + userid +
                ", goodid=" + goodid +
                ", goodnumber=" + goodnumber +
                ", shoptime='" + shoptime + '\'' +
                '}';
    }
}