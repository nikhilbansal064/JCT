package com.example.nikhilbansal.jct.update_password;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.update_password.model.UpdatePasswordRequest;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public interface UpdatePasswordInterface {
    public interface IUpdatePasswordView{
        public void apiSuccess(String message);
        public void apiFailure(String message);
    }

    public interface IUpdatePasswordPresenter{
        public void callUpdatePasswordApi(UpdatePasswordRequest request);
    }

    public interface IUpdatePasswordInteractor{
        public void updatePassword(UpdatePasswordRequest request, ApiCallback callback);
    }
}
