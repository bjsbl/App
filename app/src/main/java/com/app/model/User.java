package com.app.model;

/**
 * Created by Administrator on 2015/8/15 0015.
 */
public class User extends Base {

    private String name;
    private String gender;
    private String account;
    private String password;
    private boolean isRememberMe;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRememberMe() {
        return isRememberMe;
    }
}
