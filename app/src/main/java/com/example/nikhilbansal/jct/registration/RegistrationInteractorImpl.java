package com.example.nikhilbansal.jct.registration;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.registration.model.RegistrationRequest;
import com.example.nikhilbansal.jct.registration.model.RegistrationResponse;

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
                if(null != response && response instanceof RegistrationResponse){
                    //store necessary information
                    callback.onSuccess(((RegistrationResponse) response).getData().getMessage());
                }
            }

            @Override
            public void onFailure(String failureMsg) {
                callback.onFailure(failureMsg);
            }
        });
    }
}
