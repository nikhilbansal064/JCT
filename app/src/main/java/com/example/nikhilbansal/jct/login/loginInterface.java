package com.example.nikhilbansal.jct.login;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.login.model.LoginRequest;
import com.example.nikhilbansal.jct.login.model.LoginResponse;

/**
 * Created by Nikhil Bansal on 28-10-2017.
 */

public interface loginInterface {

    public interface ILoginView{
        public void loginSuccess();
        public void loginFailure(String failureMsg);
    }

    public interface ILoginPresenter{
        public void callLoginApi(LoginRequest loginRequest);
    }
    public interface ILoginInteractor{
        public void memberLogin(LoginRequest loginRequest, ApiCallback callback);
    }
}
