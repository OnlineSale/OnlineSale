package com.shop.model;

import java.util.List;

/**
 * Created by yuan on 16-5-5.
 */
public class UserInfo {
    private String userName;
    private String userId;
    private List<String> userGroups;

    public void setUserGroups(List<String> userGroups) {
        this.userGroups = userGroups;
    }

    public List<String> getUserGroups() {
        return userGroups;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
