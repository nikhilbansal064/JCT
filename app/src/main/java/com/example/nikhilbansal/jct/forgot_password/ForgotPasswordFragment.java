package com.example.nikhilbansal.jct.forgot_password;

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
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.forgot_password.model.ForgotPasswordResponse;
import com.example.nikhilbansal.jct.utils.DialogUtils;
import com.example.nikhilbansal.jct.utils.Utils;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class ForgotPasswordFragment extends BaseFragment implements ForgotPasswordInterface.IForgotPasswordView, View.OnClickListener {

    private EditText etEmail;
    private Button btnResetPassword;

    private View view;
    private ForgotPasswordPresenterImpl mPresenter;

    public static ForgotPasswordFragment newInstance(){
        return new ForgotPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        mPresenter = new ForgotPasswordPresenterImpl(this);
        initView();

        return view;
    }

    private void initView() {
        etEmail = (EditText) view.findViewById(R.id.et_forgot_password_email_id);
        btnResetPassword = (Button) view.findViewById(R.id.btn_reset_password);

        btnResetPassword.setOnClickListener(this);
    }

    @Override
    public void success(ForgotPasswordResponse response) {
        hideLoading();
        DialogUtils.showSuccessMessageDialog(getActivity(), response.getData().getMessage());

    }

    @Override
    public void failure(String failureMsg) {
        hideLoading();
        DialogUtils.showErrorMessageDialog(getActivity(), failureMsg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_reset_password:
                resetPassword();
                break;
        }
    }

    private void resetPassword() {
        String email = etEmail.getText().toString();

        if(TextUtils.isEmpty(email)){
            etEmail.setError(getString(R.string.empty_email_error_msg));
        }else if(!Utils.isValidEmail(email)){
            etEmail.setError(getString(R.string.valid_email_error_msg));
        }else {
            if(null != mPresenter){
                showLoading(getActivity());
                mPresenter.callForgotPasswordApi(email);
            }
        }
    }
}
