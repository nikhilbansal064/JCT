package com.example.nikhilbansal.jct.update_profile;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.UserInfo;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public interface UpdateProfileInterface {

    public interface IUpdateProfileView{
        public void apiSuccess(String message);
        public void apiFailure(String message);
    }

    public interface IUpdateProfilePresenter{
        public void callUpdateProfile(UserInfo userInfo);
    }

    public interface IUpdateProfileInteractor{
        public void updateProfile(UserInfo userInfo, ApiCallback callback);
    }
}
