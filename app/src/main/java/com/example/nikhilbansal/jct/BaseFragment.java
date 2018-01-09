package com.example.nikhilbansal.jct;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.example.nikhilbansal.jct.utils.Utils;

/**
 * Created by Nikhil Bansal on 04-11-2017.
 */

public class BaseFragment extends Fragment {

    private ProgressDialog mProgressDialog;

    public void showLoading(Context mContext) {
        hideLoading();
        mProgressDialog = Utils.showLoadingDialog(mContext);
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    public void setTitle(String title) {

        if(!TextUtils.isEmpty(title) && isAdded()) {
            ((BaseActivity) getActivity()).setScreenTitle(title);
        }
    }

    public void setBackButton(){
        if(isAdded()) {
            ((MainActivity) getActivity()).setNavigationIcon(R.drawable.common_google_signin_btn_icon_dark, "BACK");
        }
    }

    public void setMenuButton(){
        if(isAdded()) {
            ((MainActivity) getActivity()).setNavigationIcon(R.drawable.jct_logo_pressed, "MENU");
        }
    }

}
