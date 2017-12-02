package com.example.nikhilbansal.jct.forgot_password;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.forgot_password.model.ForgotPasswordResponse;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class ForgotPasswordPresenterImpl implements ForgotPasswordInterface.IForgotPasswordPresenter{
    private ForgotPasswordInterface.IForgotPasswordView mView;
    private ForgotPasswordInteractorImpl mInteractor;

    public ForgotPasswordPresenterImpl(ForgotPasswordInterface.IForgotPasswordView view) {
        mView = view;
        mInteractor = new ForgotPasswordInteractorImpl(this);
    }

    @Override
    public void callForgotPasswordApi(String email) {
        mInteractor.forgotPassword(email, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                mView.success((ForgotPasswordResponse)response);
            }

            @Override
            public void onFailure(String failureMsg) {
                mView.failure(failureMsg);
            }
        });
    }
}
