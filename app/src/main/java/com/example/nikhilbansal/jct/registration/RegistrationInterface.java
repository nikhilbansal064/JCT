package com.example.nikhilbansal.jct.registration;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.registration.model.RegistrationRequest;
import com.example.nikhilbansal.jct.registration.model.RegistrationResponse;

/**
 * Created by Nikhil Bansal on 11-11-2017.
 */

public interface RegistrationInterface {
    public interface IRegistrationVIew{
        public void registrationSuccess(String message);
        public void registrationFail(String message);
    }

    public interface IRegistrationPresenter{

        public void callRegistrationApi(RegistrationRequest registrationRequest);
    }

    public interface IRegistrationInteractor{

        public void registration(RegistrationRequest registrationRequest, ApiCallback callback);


    }
}
