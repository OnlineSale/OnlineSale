package com.shop.model;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private Integer paypassword;

    private String registtime;

    private String idcard;

    private String phone;

    private Integer integralid;

    private Integer memberlevel;

    private String userimage;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(Integer paypassword) {
        this.paypassword = paypassword;
    }

    public String getRegisttime() {
        return registtime;
    }

    public void setRegisttime(String registtime) {
        this.registtime = registtime == null ? null : registtime.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIntegralid() {
        return integralid;
    }

    public void setIntegralid(Integer integralid) {
        this.integralid = integralid;
    }

    public Integer getMemberlevel() {
        return memberlevel;
    }

    public void setMemberlevel(Integer memberlevel) {
        this.memberlevel = memberlevel;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage == null ? null : userimage.trim();
    }
}