package com.example.nikhilbansal.jct.update_login_id;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.update_login_id.model.UpdateLoginIdRequest;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateLoginIdPresenterImpl implements UpdateLoginIdInterface.IUpdateLoginIdPresenter {

    private UpdateLoginIdInterface.IUpdateLoginIdView mView;
    private UpdateLoginIdInteractorImpl mInteractor;

    public UpdateLoginIdPresenterImpl(UpdateLoginIdInterface.IUpdateLoginIdView view) {
        this.mView = view;
        this.mInteractor = new UpdateLoginIdInteractorImpl(this);
    }

    @Override
    public void callUpdateLoginIdApi(final UpdateLoginIdRequest request) {
        mInteractor.updateLoginId(request, new ApiCallback() {
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
