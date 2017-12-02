package com.example.nikhilbansal.jct.registration.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Bansal on 04-11-2017.
 */

public class RegistrationResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("user_email")
        @Expose
        private String userEmail;
        @SerializedName("user")
        @Expose
        private Integer user;
        @SerializedName("sess_id")
        @Expose
        private String sessId;
        @SerializedName("currency")
        @Expose
        private Object currency;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public Integer getUser() {
            return user;
        }

        public void setUser(Integer user) {
            this.user = user;
        }

        public String getSessId() {
            return sessId;
        }

        public void setSessId(String sessId) {
            this.sessId = sessId;
        }

        public Object getCurrency() {
            return currency;
        }

        public void setCurrency(Object currency) {
            this.currency = currency;
        }

    }
}
