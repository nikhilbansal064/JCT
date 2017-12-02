package com.example.nikhilbansal.jct.update_profile;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.constant.ApiConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateProfileInteractorImpl implements UpdateProfileInterface.IUpdateProfileInteractor {

    @Override
    public void updateProfile(UserInfo userInfo, final ApiCallback callback) {

        final Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", ApiConstants.API_UPDATE_PROFILE_ACTION);
        requestMap.put("user", userInfo.getUser());
        requestMap.put("tlt", userInfo.getTlt());
        requestMap.put("fname", userInfo.getFname());
        requestMap.put("company", userInfo.getCompany());
        requestMap.put("address_1", userInfo.getAddress1());
        requestMap.put("address_2", userInfo.getAddress2());
        requestMap.put("city", userInfo.getCity());
        requestMap.put("state", userInfo.getState());
        requestMap.put("country", userInfo.getCountry());
        requestMap.put("country_port", userInfo.getPortOfDest());
        requestMap.put("email_2", userInfo.getEmail2());
        requestMap.put("telephone_1", userInfo.getTelephone1());
        requestMap.put("telephone_2", userInfo.getTelephone2());
        requestMap.put("mobile", userInfo.getMobile());
        requestMap.put("is_newsletter", userInfo.getIsNewsLetter());

        ApiManagement.updateLoginId(requestMap, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                if(null != response && response instanceof CommonResponse){
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
