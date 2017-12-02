package com.example.nikhilbansal.jct.api;

import com.example.nikhilbansal.jct.constant.ApiConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nikhil Bansal on 26-10-2017.
 */

public class ApiAdapter {
    private static String BASE_URL = "https://www.japanesecartrade.com/";
    private static Retrofit mRetrofit = null;
    private static Retrofit.Builder retrofitBuilder = null;
    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);


    public static <T> T createClient(Class <T> apiInterface){
        if(null == mRetrofit){
            httpClientBuilder.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
            enableLogging();
            buildAdapter();
        }

        return mRetrofit.create(apiInterface);
    }

    private static void buildAdapter() {

        if(null == retrofitBuilder) {
            retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClientBuilder.build());
        }

        mRetrofit = retrofitBuilder.build();
    }

    private static void enableLogging() {

        if(! httpClientBuilder.interceptors().contains(logging)){
            httpClientBuilder.addInterceptor(logging);
        }
    }
}
