package com.example.nikhilbansal.jct.update_profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.UserInfo;
import com.example.nikhilbansal.jct.constant.Constants;
import com.example.nikhilbansal.jct.utils.DialogUtils;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UpdateProfileFragment extends BaseFragment implements UpdateProfileInterface.IUpdateProfileView, View.OnClickListener {
    private View view;
    private UpdateProfilePresenterImpl mPresenter;
    private UserInfo updatedUserInfo;

    private EditText etCompany, etAdd1, etAdd2, etCity, etState, etZip,etCountry, etCountryShippingPort,
            etLoginId, etAltEmail, etTel1, etTel2, etMobile, etName;

    private Button btnUpdate;
    private CheckBox cbNewsLetterSubs;
    private AppCompatSpinner spinnerSalutation;

    public static UpdateProfileFragment newInstance(){
        UpdateProfileFragment fragment = new UpdateProfileFragment();

        if(null == fragment.updatedUserInfo){
            fragment.updatedUserInfo = new UserInfo();
        }

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_update_profile, container, false);

        mPresenter = new UpdateProfilePresenterImpl(this);
        initView();
        return view;
    }

    private void initView() {

        spinnerSalutation = (AppCompatSpinner) view.findViewById(R.id.spinner_salutation);
        etName = (EditText) view.findViewById(R.id.et_name);
        etCompany = (EditText) view.findViewById(R.id.et_company);
        etAdd1 = (EditText) view.findViewById(R.id.et_address_1);
        etAdd2 = (EditText) view.findViewById(R.id.et_address_2);
        etCity = (EditText) view.findViewById(R.id.et_city);
        etState = (EditText) view.findViewById(R.id.et_state);
        etZip = (EditText) view.findViewById(R.id.et_zip_code);
        etCountry = (EditText) view.findViewById(R.id.et_country);
        etCountryShippingPort = (EditText) view.findViewById(R.id.et_shipping_country_port);
        etLoginId = (EditText) view.findViewById(R.id.et_login_id);
        etAltEmail = (EditText) view.findViewById(R.id.et_alternate_email);
        etTel1 = (EditText) view.findViewById(R.id.et_telephone);
        etTel2 = (EditText) view.findViewById(R.id.et_alternate_telephone);
        etMobile = (EditText) view.findViewById(R.id.et_mobile);
        cbNewsLetterSubs = (CheckBox) view.findViewById(R.id.cb_suscribe_newsletter);
        btnUpdate = (Button) view.findViewById(R.id.btn_update_profile);

        //initialise spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.salutation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalutation.setAdapter(adapter);

        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update_profile:
                updateProfile();
        }
    }

    private void updateProfile() {
        //prepare request
        if(null == updatedUserInfo){
            updatedUserInfo = new UserInfo();
        }


        updatedUserInfo.setUser("21475"); //need to be get from shared pref
        updatedUserInfo.setTlt(spinnerSalutation.getSelectedItem().toString());
        updatedUserInfo.setFname(etName.getText().toString());
        updatedUserInfo.setCompany(etCompany.getText().toString());
        updatedUserInfo.setAddress1(etAdd1.getText().toString());
        updatedUserInfo.setAddress2(etAdd2.getText().toString());
        updatedUserInfo.setCity(etCity.getText().toString());
        updatedUserInfo.setState(etState.getText().toString());
        updatedUserInfo.setZip(etZip.getText().toString());
        updatedUserInfo.setCountry(etCountry.getText().toString());
        updatedUserInfo.setPortOfDest(etCountryShippingPort.getText().toString());
        updatedUserInfo.setUserEmail(etLoginId.getText().toString());
        updatedUserInfo.setEmail2(etAltEmail.getText().toString());
        updatedUserInfo.setTelephone1(etTel1.getText().toString());
        updatedUserInfo.setTelephone2(etTel2.getText().toString());
        updatedUserInfo.setMobile(etMobile.getText().toString());

        if(cbNewsLetterSubs.isChecked()){
            updatedUserInfo.setIsNewsLetter(Constants.CHECKED);
        }else {
            updatedUserInfo.setIsNewsLetter(Constants.UN_CHECKED);
        }


        showLoading(getActivity());
        mPresenter.callUpdateProfile(updatedUserInfo);
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
