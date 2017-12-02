package com.example.nikhilbansal.jct.utils;

import android.content.SharedPreferences;

import com.example.nikhilbansal.jct.JCTApplication;

/**
 * Created by Nikhil Bansal on 26-10-2017.
 */

public class SharePreferenceData {

    private static final String PREF_NAME = "JCT_PREF";
    private static final int PREF_MODE = 0;
    private SharedPreferences sharedPref;
    private static SharePreferenceData sharedPreferenceData;

    public static final String KEY_USER_ID = "user id";
    public static final String KEY_USER_LOGGED_IN = "user logged in";

    private SharePreferenceData(){}

    public static SharePreferenceData getInstance(){

        if(null == sharedPreferenceData){
            sharedPreferenceData = new SharePreferenceData();
        }

        sharedPreferenceData.sharedPref = JCTApplication.getInstance().getSharedPreferences(PREF_NAME, PREF_MODE);
        return sharedPreferenceData;
    }

    public String getString(String key){
        return sharedPref.getString(key, "");
    }

    public void saveString(String key, String value){
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveBooleanValue(String key, boolean value){
        SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBooleanValue(String key){
        return sharedPref.getBoolean(key,false);
    }



    private SharedPreferences.Editor getEditor() {

        return sharedPref.edit();
    }

    public void clearAll(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }


}
