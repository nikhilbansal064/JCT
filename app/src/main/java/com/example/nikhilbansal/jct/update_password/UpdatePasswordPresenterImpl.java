package com.example.nikhilbansal.jct.update_password;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.update_password.model.UpdatePasswordRequest;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdatePasswordPresenterImpl implements UpdatePasswordInterface.IUpdatePasswordPresenter {

    private UpdatePasswordInterface.IUpdatePasswordView mView;
    private UpdatePasswordInteractorImpl mInteractor;

    public UpdatePasswordPresenterImpl(UpdatePasswordInterface.IUpdatePasswordView view) {
        this.mView = view;
        this.mInteractor = new UpdatePasswordInteractorImpl(this);
    }

    @Override
    public void callUpdatePasswordApi(final UpdatePasswordRequest request) {

        mInteractor.updatePassword(request, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                mView.apiSuccess(((CommonResponse)response).getData().getMessage());
            }

            @Override
            public void onFailure(String failureMsg) {
                mView.apiFailure(failureMsg);
            }
        });

    }
}
