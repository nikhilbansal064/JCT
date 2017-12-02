package com.example.nikhilbansal.jct;

import android.app.Application;

/**
 * Created by Nikhil Bansal on 27-10-2017.
 */

public class JCTApplication extends Application {
    public static JCTApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static JCTApplication getInstance(){
        return mApplication;
    }
}
