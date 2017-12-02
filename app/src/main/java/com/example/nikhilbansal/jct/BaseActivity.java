package com.example.nikhilbansal.jct;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;

import com.example.nikhilbansal.jct.constant.Constants;
import com.example.nikhilbansal.jct.utils.FontFactory;
import com.ranosys.rtp.RunTimePermissionActivity;

public class BaseActivity extends RunTimePermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            this.finish();
        }
    }

    public void setScreenTitle(String title){
        if(getSupportActionBar() != null) {
            SpannableString spannableString = new SpannableString(title);
            spannableString.setSpan(FontFactory.getFont(Constants.KEY_FONT_AWESOME), 0, spannableString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(spannableString);
        }
    }

}
