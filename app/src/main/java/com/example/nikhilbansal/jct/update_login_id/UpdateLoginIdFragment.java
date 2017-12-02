package com.example.nikhilbansal.jct.update_login_id;

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
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.update_login_id.model.UpdateLoginIdRequest;
import com.example.nikhilbansal.jct.utils.DialogUtils;
import com.example.nikhilbansal.jct.utils.Utils;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateLoginIdFragment extends BaseFragment implements UpdateLoginIdInterface.IUpdateLoginIdView, View.OnClickListener {

    private View view;
    private UpdateLoginIdPresenterImpl mPresenter;

    private TextView tvCurrentLoginId;
    private EditText etPassword;
    private EditText etNewLoginId;
    private EditText etConfirmNewLoginId;
    private Button btnUpdate;

    public static UpdateLoginIdFragment newInstance(){
        return new UpdateLoginIdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_update_login_id, container,  false);

        mPresenter = new UpdateLoginIdPresenterImpl(this);
        initViews();
        return view;
    }

    private void initViews() {
        tvCurrentLoginId = (TextView) view.findViewById(R.id.tv_current_login_id);
        tvCurrentLoginId.setText("nilesh@eximweb.jp"); //need be pre filled form shared Preference
        etPassword = (EditText) view.findViewById(R.id.et_password);
        etNewLoginId = (EditText) view.findViewById(R.id.et_new_login_id);
        etConfirmNewLoginId = (EditText) view.findViewById(R.id.et_confirm_new_login_id);
        btnUpdate = (Button) view.findViewById(R.id.btn_update_login_id);

        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update_login_id:
                updateLoginId();
        }
    }

    private void updateLoginId() {

        if(isDataValid()){
            UpdateLoginIdRequest request = new UpdateLoginIdRequest();
            request.setAction(ApiConstants.API_UPDATE_LOGIN_ID_ACTION);
            request.setUserId("21745");//need to be get from prefrences
            request.setCurrentPassword(etPassword.getText().toString());
            request.setNewLoginId(etNewLoginId.getText().toString());
            request.setConfirmNewLoginId(etConfirmNewLoginId.getText().toString());

            showLoading(getActivity());
            mPresenter.callUpdateLoginIdApi(request);
        }
    }

    private boolean isDataValid() {
        String password = etPassword.getText().toString();
        String newId = etNewLoginId.getText().toString();
        String confirmId = etConfirmNewLoginId.getText().toString();

        boolean isValid = true;

        if(TextUtils.isEmpty(password)){
            isValid = false;
            etPassword.setError(getString(R.string.empty_password_id_error_msg));
        }

        if(TextUtils.isEmpty(newId)){
            isValid = false;
            etNewLoginId.setError(getString(R.string.empty_login_id_error_msg));
        }else if(!Utils.isValidEmail(newId)){
            isValid = false;
            etNewLoginId.setError(getString(R.string.valid_email_error_msg));
        }

        if(TextUtils.isEmpty(confirmId)){
            isValid = false;
            etConfirmNewLoginId.setError(getString(R.string.empty_login_id_error_msg));
        }else if(!newId.contentEquals(confirmId)){
            isValid = false;
            etConfirmNewLoginId.setError(getString(R.string.login_id_mismatch_error));
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
        DialogUtils.showErrorMessageDialog(getActivity(), message);
    }


}
