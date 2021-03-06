package com.shop.model;

public class Order {
    private String orderid;

    private Integer userid;

    private Double total;

    private Double costdiscount;

    private String remark;

    private String shoptime;

    private Integer orderstate;

    private Integer payway;

    private Integer carriageid;

    private String paytime;

    private String sendgoodtime;

    private String completetime;

    private Integer commentstate;

    private String logisticsid;

    private Integer isdelete;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCostdiscount() {
        return costdiscount;
    }

    public void setCostdiscount(Double costdiscount) {
        this.costdiscount = costdiscount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getShoptime() {
        return shoptime;
    }

    public void setShoptime(String shoptime) {
        this.shoptime = shoptime == null ? null : shoptime.trim();
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getPayway() {
        return payway;
    }

    public void setPayway(Integer payway) {
        this.payway = payway;
    }

    public Integer getCarriageid() {
        return carriageid;
    }

    public void setCarriageid(Integer carriageid) {
        this.carriageid = carriageid;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime == null ? null : paytime.trim();
    }

    public String getSendgoodtime() {
        return sendgoodtime;
    }

    public void setSendgoodtime(String sendgoodtime) {
        this.sendgoodtime = sendgoodtime == null ? null : sendgoodtime.trim();
    }

    public String getCompletetime() {
        return completetime;
    }

    public void setCompletetime(String completetime) {
        this.completetime = completetime == null ? null : completetime.trim();
    }

    public Integer getCommentstate() {
        return commentstate;
    }

    public void setCommentstate(Integer commentstate) {
        this.commentstate = commentstate;
    }

    public String getLogisticsid() {
        return logisticsid;
    }

    public void setLogisticsid(String logisticsid) {
        this.logisticsid = logisticsid == null ? null : logisticsid.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}