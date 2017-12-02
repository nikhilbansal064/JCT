package com.example.nikhilbansal.jct.update_password;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.update_password.model.UpdatePasswordRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdatePasswordInteractorImpl implements UpdatePasswordInterface.IUpdatePasswordInteractor {

    private UpdatePasswordPresenterImpl mPresenter;

    public UpdatePasswordInteractorImpl(UpdatePasswordPresenterImpl updatePasswordPresenter) {
        mPresenter = updatePasswordPresenter;
    }

    @Override
    public void updatePassword(final UpdatePasswordRequest request, final ApiCallback callback) {

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", request.getAction());
        requestMap.put("user", request.getUserId());
        requestMap.put("current_password", request.getCurrentPassword());
        requestMap.put("new_password", request.getNewPassword());
        requestMap.put("confirm_password", request.getConfirmNewPassword());

        ApiManagement.updatePassword(requestMap, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                if(null != request && response instanceof CommonResponse){
                    callback.onSuccess((CommonResponse)response);
                }
            }

            @Override
            public void onFailure(String failureMsg) {
                callback.onFailure(failureMsg);
            }
        });

    }
}
