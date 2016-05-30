package com.shop.authentication.model;

/**
 * Created by yuan on 16-5-5.
 */
public class AuthenticateInfo {
    private String userId;
    private String userGroup;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getUserGroup() {
        return userGroup;
    }
}
