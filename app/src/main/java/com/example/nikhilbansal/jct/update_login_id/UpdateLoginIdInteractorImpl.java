package com.example.nikhilbansal.jct.update_login_id;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.update_login_id.model.UpdateLoginIdRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateLoginIdInteractorImpl implements UpdateLoginIdInterface.IUpdateLoginIdInteractor {

    private UpdateLoginIdPresenterImpl mPresenter;

    public UpdateLoginIdInteractorImpl(UpdateLoginIdPresenterImpl updateLoginIdPresenter) {
        this.mPresenter = updateLoginIdPresenter;
    }

    @Override
    public void updateLoginId(final UpdateLoginIdRequest request, final ApiCallback callback) {

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", request.getAction());
        requestMap.put("user", request.getUserId());
        requestMap.put("current_password", request.getCurrentPassword());
        requestMap.put("new_member", request.getNewLoginId());
        requestMap.put("confirm_member", request.getConfirmNewLoginId());

        ApiManagement.updateLoginId(requestMap, new ApiCallback() {
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
