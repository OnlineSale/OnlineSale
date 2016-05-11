package com.shop.model;

/**
 * Created by yuan on 16-5-5.
 */
public class LoginInfo {
    private String userName;
    private String passWord;
    private String validCode;

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }
}
