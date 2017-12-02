package com.example.nikhilbansal.jct;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;

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

}
