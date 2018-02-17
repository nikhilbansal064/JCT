package com.example.nikhilbansal.jct.login;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.login.model.LoginRequest;
import com.example.nikhilbansal.jct.login.model.LoginResponse;

/**
 * Created by Nikhil Bansal on 28-10-2017.
 */

public class LoginPresenterImpl implements loginInterface.ILoginPresenter {

    private static loginInterface.ILoginView mView;
    private static LoginInteractorImpl mInteractor;

    public  LoginPresenterImpl(loginInterface.ILoginView view){
        mView = view;
        mInteractor = new LoginInteractorImpl(this);
    }

    @Override
    public void callLoginApi(LoginRequest loginRequest) {
        mInteractor.memberLogin(loginRequest, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                mView.loginSuccess();
            }

            @Override
            public void onFailure(String failureMsg) {
                mView.loginFailure(failureMsg);
            }
        });
    }
}
