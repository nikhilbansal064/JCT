package com.example.nikhilbansal.jct;

/**
 * Created by Nikhil Bansal on 28-10-2017.
 */

public interface ApiCallback {
    public void onSuccess(Object response);
    public void onFailure(String failureMsg);
}
