package com.example.nikhilbansal.jct.update_password;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.update_password.model.UpdatePasswordRequest;
import com.example.nikhilbansal.jct.utils.DialogUtils;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdatePasswordFragment extends BaseFragment implements UpdatePasswordInterface.IUpdatePasswordView, View.OnClickListener {

    private EditText etCurrentPassword;
    private EditText etNewPassword;
    private EditText etConfirmNewPassword;
    private Button btnUpdate;

    private View view;
    private UpdatePasswordPresenterImpl mPresenter;

    public static UpdatePasswordFragment newInstance(){
        return new UpdatePasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_update_password, container, false);

        mPresenter = new UpdatePasswordPresenterImpl(this);
        initView();
        return view;
    }

    private void initView() {
        etCurrentPassword = (EditText) view.findViewById(R.id.et_current_password);
        etNewPassword = (EditText) view.findViewById(R.id.et_new_password);
        etConfirmNewPassword = (EditText) view.findViewById(R.id.et_confirm_new_password);
        btnUpdate = (Button) view.findViewById(R.id.btn_update_password);

        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update_password:
                updatePassword();
        }
    }

    private void updatePassword() {

        if(isValidData()){
            UpdatePasswordRequest request = new UpdatePasswordRequest();
            request.setAction(ApiConstants.API_UPDATE_PASSWORD_ACTION);
            request.setUserId("21475"); // need to be get form shared pref
            request.setCurrentPassword(etCurrentPassword.getText().toString());
            request.setNewPassword(etNewPassword.getText().toString());
            request.setConfirmNewPassword(etConfirmNewPassword.getText().toString());

            showLoading(getActivity());
            mPresenter.callUpdatePasswordApi(request);
        }
    }

    private boolean isValidData() {

        String currentPassword = etCurrentPassword.getText().toString();
        String newPassword = etNewPassword.getText().toString();
        String confirmPassword = etConfirmNewPassword.getText().toString();

        boolean isValid = true;

        if(TextUtils.isEmpty(currentPassword)){
            isValid = false;
            etCurrentPassword.setError(getString(R.string.empty_password_id_error_msg));
        }

        if(TextUtils.isEmpty(newPassword)){
            isValid = false;
            etNewPassword.setError(getString(R.string.empty_new_password_id_error_msg));
        }

        if(TextUtils.isEmpty(confirmPassword)){
            isValid = false;
            etConfirmNewPassword.setError(getString(R.string.empty_confirm_password_id_error_msg));
        }else if(!confirmPassword.contentEquals(newPassword)){
            isValid = false;
            etConfirmNewPassword.setError(getString(R.string.password_mismatch_error));
        }

        return isValid;
    }

    @Override
    public void apiSuccess(String message) {
        hideLoading();
        DialogUtils.showSuccessMessageDialog(getActivity(), message);
    }

    @Override
    public void apiFailure(String message) {
        hideLoading();
        DialogUtils.showSuccessMessageDialog(getActivity(), message);
    }


}
