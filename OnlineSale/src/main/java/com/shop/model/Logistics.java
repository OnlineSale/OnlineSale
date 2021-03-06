package com.shop.model;

public class Logistics {
    private String logisticsid;

    private Integer userid;

    private String orderid;

    private String address;

    private String receiver;

    private Integer phone;

    private String fixphone;

    private Integer postcode;

    private String logisticscom;

    private String logisticsnumber;

    public String getLogisticsid() {
        return logisticsid;
    }

    public void setLogisticsid(String logisticsid) {
        this.logisticsid = logisticsid == null ? null : logisticsid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getFixphone() {
        return fixphone;
    }

    public void setFixphone(String fixphone) {
        this.fixphone = fixphone == null ? null : fixphone.trim();
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getLogisticscom() {
        return logisticscom;
    }

    public void setLogisticscom(String logisticscom) {
        this.logisticscom = logisticscom == null ? null : logisticscom.trim();
    }

    public String getLogisticsnumber() {
        return logisticsnumber;
    }

    public void setLogisticsnumber(String logisticsnumber) {
        this.logisticsnumber = logisticsnumber == null ? null : logisticsnumber.trim();
    }
}