package com.example.nikhilbansal.jct.registration;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.login.model.LoginResponse;
import com.example.nikhilbansal.jct.registration.model.RegistrationRequest;
import com.example.nikhilbansal.jct.registration.model.RegistrationResponse;
import com.example.nikhilbansal.jct.utils.SharePreferenceData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 11-11-2017.
 */

public class RegistrationInteractorImpl implements RegistrationInterface.IRegistrationInteractor {

    @Override
    public void registration(final RegistrationRequest registrationRequest, final ApiCallback callback) {

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", registrationRequest.getAction());
        requestMap.put("tlt", registrationRequest.getSalutation());
        requestMap.put("fname", registrationRequest.getName());
        requestMap.put("email", registrationRequest.getEmail());
        requestMap.put("country", registrationRequest.getCountry());

        ApiManagement.register(requestMap, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                if(null != response && response instanceof LoginResponse){
                    //store necessary information
                    saveUserData((LoginResponse) response);
                    callback.onSuccess(((LoginResponse) response).getData().getMessage());
                }
            }

            @Override
            public void onFailure(String failureMsg) {
                callback.onFailure(failureMsg);
            }
        });
    }

    private void saveUserData(LoginResponse response) {
        Gson gson = new Gson();
        String userDataStr = gson.toJson(response);
        SharePreferenceData sp = SharePreferenceData.getInstance();
        sp.clearAll();
        sp.saveBooleanValue(SharePreferenceData.KEY_USER_LOGGED_IN, true);
        sp.saveString(SharePreferenceData.KEY_USER_DATA, userDataStr);
    }
}
