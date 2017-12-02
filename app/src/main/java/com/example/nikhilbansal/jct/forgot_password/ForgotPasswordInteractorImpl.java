package com.example.nikhilbansal.jct.forgot_password;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.forgot_password.model.ForgotPasswordResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class ForgotPasswordInteractorImpl implements ForgotPasswordInterface.IForgotPasswordInteractor {
    private ForgotPasswordPresenterImpl mPresenter;
    public ForgotPasswordInteractorImpl(ForgotPasswordPresenterImpl forgotPasswordPresenter) {
        mPresenter = forgotPasswordPresenter;
    }


    @Override
    public void forgotPassword(String email, final ApiCallback callback) {

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", ApiConstants.API_FORGOT_PASSWORD_ACTION);
        requestMap.put("email", email);

        ApiManagement.forgotPassword(requestMap, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                callback.onSuccess((ForgotPasswordResponse)response);
            }

            @Override
            public void onFailure(String failureMsg) {
                callback.onFailure(failureMsg);
            }
        });
    }
}
