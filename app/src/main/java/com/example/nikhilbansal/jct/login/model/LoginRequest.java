package com.example.nikhilbansal.jct.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Bansal on 11-11-2017.
 */

public class LoginRequest {

    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("loginid")
    @Expose
    private String loginid;
    @SerializedName("password")
    @Expose
    private String password;

    public LoginRequest(String apiLoginAction, String loginId, String password) {
        this.action = apiLoginAction;
        this.loginid = loginId;
        this.password = password;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
