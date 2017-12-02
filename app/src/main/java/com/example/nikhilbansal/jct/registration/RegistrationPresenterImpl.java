package com.example.nikhilbansal.jct.registration;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.registration.model.RegistrationRequest;
import com.example.nikhilbansal.jct.registration.model.RegistrationResponse;

/**
 * Created by Nikhil Bansal on 11-11-2017.
 */

public class RegistrationPresenterImpl implements RegistrationInterface.IRegistrationPresenter {
    private RegistrationInterface.IRegistrationVIew mView;
    private RegistrationInterface.IRegistrationInteractor mInteractor;

    public RegistrationPresenterImpl(RegistrationInterface.IRegistrationVIew view) {
        mView = view;
        mInteractor = new RegistrationInteractorImpl();
    }

    @Override
    public void callRegistrationApi(final RegistrationRequest registrationRequest) {
        mInteractor.registration(registrationRequest, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                if(null != response && response instanceof String)
                mView.registrationSuccess((String) response);
            }

            @Override
            public void onFailure(String failureMsg) {
                mView.registrationFail(failureMsg);
            }
        });
    }
}
