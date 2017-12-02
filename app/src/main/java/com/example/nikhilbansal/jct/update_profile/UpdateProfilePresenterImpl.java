package com.example.nikhilbansal.jct.update_profile;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.UserInfo;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateProfilePresenterImpl implements UpdateProfileInterface.IUpdateProfilePresenter {

    private UpdateProfileInterface.IUpdateProfileView mView;
    private UpdateProfileInteractorImpl mInteractor;

    public UpdateProfilePresenterImpl(UpdateProfileInterface.IUpdateProfileView view) {
        this.mView = view;
        this.mInteractor = new UpdateProfileInteractorImpl();
    }

    @Override
    public void callUpdateProfile(UserInfo userInfo) {
        mInteractor.updateProfile(userInfo, new ApiCallback() {
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
