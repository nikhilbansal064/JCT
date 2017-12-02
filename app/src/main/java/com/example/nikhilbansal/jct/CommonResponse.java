package com.example.nikhilbansal.jct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class CommonResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private CommonResponse.Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CommonResponse.Data getData() {
        return data;
    }

    public void setData(CommonResponse.Data data) {
        this.data = data;
    }



    public class Data {

        @SerializedName("message")
        @Expose
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
