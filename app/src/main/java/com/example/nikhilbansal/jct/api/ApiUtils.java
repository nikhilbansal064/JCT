package com.example.nikhilbansal.jct.api;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Nikhil Bansal on 28-10-2017.
 */

public class ApiUtils {
    private static Gson gson;
    private static String responseStr = "";

    public static<T> T parseResponse(retrofit2.Response<ResponseBody> responseBody, Class<T> responseType) throws IllegalAccessException, InstantiationException {

        responseStr = "";
        T responseObject = responseType.newInstance();

        if(null == gson){
            initGson();
        }

        try {
            responseStr = responseBody.body().string();

            if(!TextUtils.isEmpty(responseStr)){
                responseObject = gson.fromJson(responseStr, responseType);
            }else {
                throw new Exception("Error in parsing response");
            }

            return responseObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseObject;
    }

    private static void initGson() {
        gson = new Gson();
    }
}
