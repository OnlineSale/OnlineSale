package com.shop.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by yuan on 16-5-3.
 */
public class RegisterInfo {

    @NotNull(message = "{NotNull.registerinfo.userName}")
    @Pattern(regexp = "^[a-zA-Z0-9_@-]{3,15}$",message = "{Pattern.registerinfo.userName}")
    private String userName;

    @NotNull(message = "{NotNull.registerinfo.passWord}")
    @Pattern(regexp = "^[-\\da-zA-Z`=\\\\\\[\\];',./~!@#$%^&*()_+|{}:\"<>?]*$",message = "{Pattern.registerinfo.passWord}")
    private String passWord;

    //验证码
    @NotNull(message = "{NotNull.register.validCode}")
    private String validCode;

    private String realValidCode;

    @NotNull(message="{NotNull.register.phoneNumber}")
    @Pattern(regexp = "^\\d+$",message ="{Pattern.registerinfo.phoneNumber}")
    private String phoneNumber;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setRealValidCode(String realValidCode) {
        this.realValidCode = realValidCode;
    }

    public String getRealValidCode() {
        return realValidCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
