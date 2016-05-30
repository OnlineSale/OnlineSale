package com.shop.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by yuan on 16-5-28.
 */
public class ResetInfo {

    @NotNull(message = "{NotNull.registerinfo.userName}")
    @Pattern(regexp = "^[a-zA-Z0-9_@-]{3,20}$",message = "{Pattern.registerinfo.userName}")
    private String userName;

    @NotNull(message = "{NotNull.registerinfo.passWord}")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z!@#$%]).{6,20}$",message = "{Pattern.registerinfo.passWord}")
    private String password;

    private String validCode;
    private String realValidCode;
    private String resetPhone;

    public void setResetPhone(String resetPhone) {
        this.resetPhone = resetPhone;
    }

    public String getResetPhone() {
        return resetPhone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRealValidCode(String realValidCode) {
        this.realValidCode = realValidCode;
    }

    public String getRealValidCode() {
        return realValidCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }
}
