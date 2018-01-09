package com.example.nikhilbansal.jct.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.nikhilbansal.jct.BaseActivity;
import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.R;

/**
 * Created by Nikhil Bansal on 26-10-2017.
 */

public class FragmentUtils {

    public static void addFragment(final Context context, Fragment fragment, String fragmentId, boolean addToBackStack) {
        BaseActivity activity = (BaseActivity)context;
        if (fragment != null && fragment != getCurrentFragment(activity)) {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction .add(R.id.fragment_container, fragment, fragmentId);
            if(addToBackStack){
                transaction.addToBackStack(fragmentId);
            }
            transaction.commit();

        }
    }

    public static void replaceFragment(final Context context, final Fragment fragment , String fragmentId, boolean addToBackStack) {
        FragmentManager manager = ((BaseActivity)context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment,fragmentId);

        if(addToBackStack){
            transaction.addToBackStack(fragmentId);
        }
        transaction.commit();
    }



    public static BaseFragment getCurrentFragment(BaseActivity activity) {
        BaseFragment currentFragment = null;
        currentFragment = (BaseFragment) (activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        return currentFragment;
    }


}
