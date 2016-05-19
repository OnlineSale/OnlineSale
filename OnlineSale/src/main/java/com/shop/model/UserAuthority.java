package com.shop.model;

public class UserAuthority {
    private Integer usergroup;

    private String userauthority;

    public Integer getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Integer usergroup) {
        this.usergroup = usergroup;
    }

    public String getUserauthority() {
        return userauthority;
    }

    public void setUserauthority(String userauthority) {
        this.userauthority = userauthority == null ? null : userauthority.trim();
    }
}