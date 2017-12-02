package com.example.nikhilbansal.jct.forgot_password;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.forgot_password.model.ForgotPasswordResponse;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public interface ForgotPasswordInterface {

    public interface IForgotPasswordView{
        public void success(ForgotPasswordResponse response);
        public void failure(String failureMsg);
    }

    public interface IForgotPasswordPresenter{
        public void callForgotPasswordApi(String email);
    }

    public interface IForgotPasswordInteractor{
        public void forgotPassword(String email, ApiCallback callback);
    }
}
