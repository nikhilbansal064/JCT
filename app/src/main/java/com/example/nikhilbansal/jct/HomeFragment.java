package com.example.nikhilbansal.jct;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nikhilbansal.jct.utils.FragmentUtils;

/**
 * Created by Nikhil Bansal on 09-01-2018.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ImageView btnViewAllMake;
    private ImageView btnViewAllType;
    private ImageView btnQuickSearch;

    private View view;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews();
        setProperties();

        return view;
    }

    private void setProperties() {
        btnViewAllType.setOnClickListener(this);
    }

    private void initViews() {
        btnViewAllMake = (ImageView) view.findViewById(R.id.btn_view_all_make);
        btnViewAllType = (ImageView) view.findViewById(R.id.btn_view_all_type);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view_all_type:
                loadTypeListScreen();
                break;
        }
    }

    private void loadTypeListScreen() {
        FragmentUtils.addFragment(getActivity(), ExtendedListFragment.getInstance(ExtendedListFragment.BY_TYPE), "", true);
    }

    private void loadMakeListScreen() {
    }

}
