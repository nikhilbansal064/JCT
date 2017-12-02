package com.example.nikhilbansal.jct.api;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.forgot_password.model.ForgotPasswordResponse;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.login.model.LoginResponse;
import com.example.nikhilbansal.jct.registration.model.RegistrationResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nikhil Bansal on 26-10-2017.
 */

public class ApiManagement {
    private static ApiClient apiClient = ApiAdapter.createClient(ApiClient.class);

    public static void login(Map<String, String> requestMap, final ApiCallback callback){
        Call<LoginResponse> call = apiClient.login(requestMap);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = (LoginResponse) response.body();
                String status = loginResponse.getStatus();
                if(status.equalsIgnoreCase(ApiConstants.API_STATUS_SUCCESS)){
                    callback.onSuccess(loginResponse);
                }else {
                    callback.onFailure(loginResponse.getData().getMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onFailure(ApiConstants.API_URL_ERR_MSG);
            }
        });
    }

    public static void register(Map<String, String> requestMap, final ApiCallback callback){

        Call<RegistrationResponse> call = apiClient.register(requestMap);

        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                RegistrationResponse registrationResponse = (RegistrationResponse) response.body();
                String status = registrationResponse.getStatus();
                if(status.equalsIgnoreCase(ApiConstants.API_STATUS_SUCCESS)){
                    callback.onSuccess(registrationResponse);
                }else {
                    callback.onFailure(registrationResponse.getData().getMessage());
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                callback.onFailure(ApiConstants.API_URL_ERR_MSG);
            }
        });
    }

    public static void forgotPassword(Map<String, String> requestMap, final ApiCallback callback){

        Call<ForgotPasswordResponse> call = apiClient.forgotPassword(requestMap);

        call.enqueue(new Callback<ForgotPasswordResponse>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponse> call, Response<ForgotPasswordResponse> response) {
                ForgotPasswordResponse forgotPasswordResponse = (ForgotPasswordResponse) response.body();
                String status = forgotPasswordResponse.getStatus();
                if(status.equalsIgnoreCase(ApiConstants.API_STATUS_SUCCESS)){
                    callback.onSuccess(forgotPasswordResponse);
                }else {
                    callback.onFailure(forgotPasswordResponse.getData().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {
                callback.onFailure(ApiConstants.API_URL_ERR_MSG);
            }
        });
    }

    public static void updateLoginId(Map<String, String> requestMap, final ApiCallback callback){

        Call<CommonResponse> call = apiClient.updateLoginId(requestMap);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                CommonResponse commonResponse = (CommonResponse) response.body();
                String status = commonResponse.getStatus();
                if(status.equalsIgnoreCase(ApiConstants.API_STATUS_SUCCESS)){
                    callback.onSuccess(commonResponse);
                }else {
                    callback.onFailure(commonResponse.getData().getMessage());
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                callback.onFailure(ApiConstants.API_URL_ERR_MSG);
            }
        });
    }

    public static void updatePassword(Map<String, String> requestMap, final ApiCallback callback){

        Call<CommonResponse> call = apiClient.updatePassword(requestMap);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                CommonResponse commonResponse = (CommonResponse) response.body();
                String status = commonResponse.getStatus();
                if(status.equalsIgnoreCase(ApiConstants.API_STATUS_SUCCESS)){
                    callback.onSuccess(commonResponse);
                }else {
                    callback.onFailure(commonResponse.getData().getMessage());
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                callback.onFailure(ApiConstants.API_URL_ERR_MSG);
            }
        });
    }

    public static void updateProfile(Map<String, String> requestMap, final ApiCallback callback){

        Call<CommonResponse> call = apiClient.updateProfile(requestMap);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                CommonResponse commonResponse = (CommonResponse) response.body();
                String status = commonResponse.getStatus();
                if(status.equalsIgnoreCase(ApiConstants.API_STATUS_SUCCESS)){
                    callback.onSuccess(commonResponse);
                }else {
                    callback.onFailure(commonResponse.getData().getMessage());
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                callback.onFailure(ApiConstants.API_URL_ERR_MSG);
            }
        });
    }
}
