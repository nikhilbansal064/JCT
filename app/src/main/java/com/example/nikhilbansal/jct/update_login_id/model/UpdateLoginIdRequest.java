package com.example.nikhilbansal.jct.update_login_id.model;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateLoginIdRequest {
    private String action;
    private String userId;
    private String currentPassword;
    private String newLoginId;
    private String confirmNewLoginId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewLoginId() {
        return newLoginId;
    }

    public void setNewLoginId(String newLoginId) {
        this.newLoginId = newLoginId;
    }

    public String getConfirmNewLoginId() {
        return confirmNewLoginId;
    }

    public void setConfirmNewLoginId(String confirmNewLoginId) {
        this.confirmNewLoginId = confirmNewLoginId;
    }
}
