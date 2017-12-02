package com.example.nikhilbansal.jct.loginRegistration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.login.LoginFragment;
import com.example.nikhilbansal.jct.registration.RegistrationFragment;
import com.example.nikhilbansal.jct.update_login_id.UpdateLoginIdFragment;
import com.example.nikhilbansal.jct.update_password.UpdatePasswordFragment;
import com.example.nikhilbansal.jct.update_profile.UpdateProfileFragment;
import com.example.nikhilbansal.jct.utils.FragmentUtils;

/**
 * Created by Nikhil Bansal on 04-11-2017.
 */

public class LoginRegistrationFragment extends BaseFragment implements View.OnClickListener {

    private Button btnLogin;
    private Button btnRegistration;

    private View view;

    public static LoginRegistrationFragment newInstance(){
        return new LoginRegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_login_registration, container, false);

        initViews();
        return view;
    }

    private void initViews() {
        btnLogin = (Button) view.findViewById(R.id.btn_login_login_reg);
        btnRegistration = (Button) view.findViewById(R.id.btn_register_login_reg);

        btnLogin.setOnClickListener(this);
        btnRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login_login_reg :
                LoginFragment loginFragment = LoginFragment.newInstance();
                FragmentUtils.replaceFragment(getActivity(), loginFragment, LoginFragment.class.getSimpleName(), true );
                break;

            case R.id.btn_register_login_reg :
                UpdateProfileFragment registrationFragment = UpdateProfileFragment.newInstance();
                FragmentUtils.replaceFragment(getActivity(), registrationFragment, UpdateProfileFragment.class.getSimpleName(), true );
                break;

            default:
                break;
        }
    }
}
