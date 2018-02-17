package com.example.nikhilbansal.jct.api;

import com.example.nikhilbansal.jct.CommonResponse;
import com.example.nikhilbansal.jct.dealer_list.Model.DealerListResponse;
import com.example.nikhilbansal.jct.forgot_password.model.ForgotPasswordResponse;
import com.example.nikhilbansal.jct.login.model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Nikhil Bansal on 26-10-2017.
 */

public interface ApiClient {

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<LoginResponse> login(@FieldMap Map<String, String> request);

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<LoginResponse> register(@FieldMap Map<String, String> request);

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<ForgotPasswordResponse> forgotPassword(@FieldMap Map<String, String> request);

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<CommonResponse> updateLoginId(@FieldMap Map<String, String> requestMap);

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<CommonResponse> updatePassword(@FieldMap Map<String, String> requestMap);

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<CommonResponse> updateProfile(@FieldMap Map<String, String> requestMap);

    @FormUrlEncoded
    @POST("apl/ios/action.ios.apl.php")
    Call<DealerListResponse> getDealerList(@FieldMap Map<String, String> requestMap);
}
