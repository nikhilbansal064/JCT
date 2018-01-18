package com.example.nikhilbansal.jct.login;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.login.model.LoginRequest;
import com.example.nikhilbansal.jct.login.model.LoginResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 28-10-2017.
 */

public class LoginInteractorImpl implements loginInterface.ILoginInteractor {

    private LoginPresenterImpl mPresenter;

    public LoginInteractorImpl(LoginPresenterImpl presenter) {
        mPresenter = presenter;
    }

    @Override
    public void memberLogin(LoginRequest loginRequest, final ApiCallback callback) {


        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", loginRequest.getAction());
        requestMap.put("loginid", loginRequest.getLoginid());
        requestMap.put("password", loginRequest.getPassword());

        ApiManagement.login(requestMap, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                if(null != response && response instanceof LoginResponse) {
                    //save necessary information
                    callback.onSuccess(response);
                }else {
                    callback.onFailure("something went wrong");
                }
            }

            @Override
            public void onFailure(String failureMsg) {
                callback.onFailure(failureMsg);
            }
        });
    }
}
