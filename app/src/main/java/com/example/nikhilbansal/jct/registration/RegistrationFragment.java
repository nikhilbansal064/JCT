package com.example.nikhilbansal.jct.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.HomeFragment;
import com.example.nikhilbansal.jct.MainActivity;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.registration.model.RegistrationRequest;
import com.example.nikhilbansal.jct.utils.DialogUtils;
import com.example.nikhilbansal.jct.utils.FragmentUtils;
import com.example.nikhilbansal.jct.utils.Utils;

/**
 * Created by Nikhil Bansal on 04-11-2017.
 */

public class RegistrationFragment extends BaseFragment implements RegistrationInterface.IRegistrationVIew, View.OnClickListener {

    private EditText etName;
    private EditText etEmail;
    private EditText etCountry;
    private Button btnRegister;
    private AppCompatSpinner spinnerSalutation;

    private View view;
    private RegistrationPresenterImpl mPresenter;

    public static RegistrationFragment newInstance(){
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_registration, container, false);
        mPresenter = new RegistrationPresenterImpl(this);
        initViews();

        return view;
    }

    private void initViews() {

        etName = view.findViewById(R.id.et_name);
        etCountry = view.findViewById(R.id.et_country);
        etEmail = view.findViewById(R.id.et_registration_email);
        btnRegister = view.findViewById(R.id.btn_register);
        spinnerSalutation = view.findViewById(R.id.spinner_salutation);

        btnRegister.setOnClickListener(this);

        //initialise spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.salutation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalutation.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                callRegistrationAPi();
                break;
        }
    }

    private void callRegistrationAPi() {

        //prepare registration request
        RegistrationRequest request = new RegistrationRequest();
        request.setName(etName.getText().toString());
        request.setCountry(etCountry.getText().toString());
        request.setEmail(etEmail.getText().toString());
        request.setSalutation(spinnerSalutation.getSelectedItem().toString());
        request.setAction(ApiConstants.API_REGISTRATION_ACTION);

        //validation of user input
        if(validate(request)){
            showLoading(getContext());
            mPresenter.callRegistrationApi(request);
        }



    }

    private boolean validate(RegistrationRequest request) {
        boolean isValid = true;

        if(TextUtils.isEmpty(request.getName())){
            isValid = false;
            etName.setError(getString(R.string.empty_name_error_msg));
        }

        if(TextUtils.isEmpty(request.getCountry())){
            isValid = false;
            etCountry.setError(getString(R.string.empty_country_error_msg));
        }

        if(TextUtils.isEmpty(request.getEmail())){
            isValid = false;
            etEmail.setError(getString(R.string.empty_email_error_msg));
        }else if(!Utils.isValidEmail(request.getEmail())){
            isValid = false;
            etEmail.setError(getString(R.string.valid_email_error_msg));
        }

        return isValid;
    }

    @Override
    public void registrationSuccess(String  message) {
        hideLoading();
        //go to home page
        FragmentUtils.addFragment(getActivity(), HomeFragment.newInstance(), HomeFragment.class.getSimpleName(), true);

        //change content of drawer
        MainActivity.loadNavigationMenu(R.menu.logged_in_user_navigation_menu);
    }

    @Override
    public void registrationFail(String message) {
        hideLoading();
        DialogUtils.showErrorMessageDialog(getActivity(), message);
    }
}
