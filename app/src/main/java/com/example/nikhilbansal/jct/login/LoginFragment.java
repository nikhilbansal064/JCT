package com.example.nikhilbansal.jct.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.HomeFragment;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.forgot_password.ForgotPasswordFragment;
import com.example.nikhilbansal.jct.login.model.LoginRequest;
import com.example.nikhilbansal.jct.login.model.LoginResponse;
import com.example.nikhilbansal.jct.registration.RegistrationFragment;
import com.example.nikhilbansal.jct.utils.DialogUtils;
import com.example.nikhilbansal.jct.utils.FragmentUtils;
import com.example.nikhilbansal.jct.utils.SharePreferenceData;
import com.google.gson.Gson;

/**
 * Created by Nikhil Bansal on 28-10-2017.
 */

public class LoginFragment extends BaseFragment implements loginInterface.ILoginView, View.OnClickListener {

    private EditText etLoginId;
    private EditText etPassword;
    private TextView tvRegistration;
    private TextView tvForgotPassword;
    private Button btnLogin;

    private View view;

    private LoginPresenterImpl mPresenter;

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_login, container, false);

        mPresenter = new LoginPresenterImpl(this);
        initView();

        return view;
    }

    private void initView() {
        etLoginId =(EditText) view.findViewById(R.id.et_login_id);
        etPassword =(EditText) view.findViewById(R.id.et_password);
        tvRegistration =(TextView) view.findViewById(R.id.tv_register);
        tvForgotPassword =(TextView) view.findViewById(R.id.tv_forgot_password);
        btnLogin = (Button) view.findViewById(R.id.btn_login);

        tvRegistration.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_register:
                loadRegisterScreen();
                break;

            case R.id.tv_forgot_password:
                loadForgotPasswordScreen();
                break;

            case R.id.btn_login:
                if(validateCredential()){
                    callLoginApi();
                }
                break;

            default:
                break;
        }
    }

    private void loadForgotPasswordScreen() {
        ForgotPasswordFragment forgotPasswordFragment = (ForgotPasswordFragment) getFragmentManager().findFragmentByTag(ForgotPasswordFragment.class.getSimpleName());
        if(null == forgotPasswordFragment){
            forgotPasswordFragment = ForgotPasswordFragment.newInstance();
        }
        FragmentUtils.replaceFragment(getActivity(), forgotPasswordFragment, ForgotPasswordFragment.class.getSimpleName(), false );
    }

    private void loadRegisterScreen() {
        RegistrationFragment registrationFragment = (RegistrationFragment) getFragmentManager().findFragmentByTag(RegistrationFragment.class.getSimpleName());
        if(null == registrationFragment){
            registrationFragment = RegistrationFragment.newInstance();
        }
        FragmentUtils.replaceFragment(getActivity(), registrationFragment, RegistrationFragment.class.getSimpleName(), false );
    }

    private boolean validateCredential() {
        boolean isValid = true;
        String loginId = etLoginId.getText().toString();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(loginId)){
            etLoginId.setError(getString(R.string.empty_login_id_error_msg));
            isValid = false;
        }

        if(TextUtils.isEmpty(password)){
            etPassword.setError(getString(R.string.empty_password_id_error_msg));
            isValid = false;
        }

        return isValid;
    }

    private void callLoginApi() {
        String loginId = etLoginId.getText().toString();
        String password = etPassword.getText().toString();

        LoginRequest loginRequest = new LoginRequest(ApiConstants.API_LOGIN_ACTION, loginId, password);
        showLoading(getContext());
        mPresenter.callLoginApi(loginRequest);
    }

    @Override
    public void loginSuccess(LoginResponse response) {
        hideLoading();
        Gson gson = new Gson();
        String userDataStr = gson.toJson(response);
        //save data to shared pref
        saveUserData(userDataStr);
        //go to home page
        FragmentUtils.addFragment(getActivity(), HomeFragment.newInstance(), HomeFragment.class.getSimpleName(), true);

        //change content of drawer

    }

    private void saveUserData(String userData) {
        SharePreferenceData sp = SharePreferenceData.getInstance();
        sp.clearAll();
        sp.saveBooleanValue(sp.KEY_USER_LOGGED_IN, true);
        sp.saveString(sp.KEY_USER_DATA, userData);
    }

    @Override
    public void loginFailure(String failureMsg) {
        hideLoading();
        DialogUtils.showErrorMessageDialog(getActivity(), failureMsg);
    }

}
