package com.example.nikhilbansal.jct.update_login_id;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.update_login_id.model.UpdateLoginIdRequest;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public interface UpdateLoginIdInterface {
    public interface IUpdateLoginIdView{
        public void apiSuccess(String message);
        public void apiFailure(String message);
    }

    public interface IUpdateLoginIdPresenter{
        public void callUpdateLoginIdApi(UpdateLoginIdRequest request);
    }

    public interface IUpdateLoginIdInteractor{
        public void updateLoginId(UpdateLoginIdRequest request, ApiCallback callback);
    }

}
