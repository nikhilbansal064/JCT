package com.example.nikhilbansal.jct;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhilbansal.jct.utils.FragmentUtils;

import java.util.ArrayList;

/**
 * Created by Nikhil Bansal on 09-01-2018.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ImageView btnViewAllMake, btnViewAllType, btnQuickSearch;
    private GridView makeGrid;

    private View view;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews();
        setProperties();

        if(null != MainActivity.stockIds && MainActivity.stockIds.getList().size() > 0){
            makeGrid.setAdapter(new StockAdapter());
        }

        makeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "make item clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void setProperties() {
        btnViewAllMake.setOnClickListener(this);
    }

    private void initViews() {
        btnViewAllMake = view.findViewById(R.id.btn_make_view_all);
        makeGrid = view.findViewById(R.id.make_grid);
        //btnViewAllType = (ImageView) view.findViewById(R.id.btn_view_all_type);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_make_view_all:
                loadTypeListScreen();
                break;
        }
    }

    private void loadTypeListScreen() {
        FragmentUtils.addFragment(getActivity(), ExtendedListFragment.getInstance(ExtendedListFragment.BY_TYPE), "", true);
    }

    private void loadMakeListScreen() {
    }

    public class StockAdapter extends BaseAdapter{

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resources resources = getResources();

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ImageView imageView;


            TextView tvName;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
               convertView = inflater.inflate(R.layout.layout_grid_item, viewGroup, false);
            }

            imageView = convertView.findViewById(R.id.image);
            tvName = convertView.findViewById(R.id.tv_name);

            StockId.StockItem item = MainActivity.stockIds.getList().get(position);
            final int resourceId = resources.getIdentifier(item.getName(), "drawable", getActivity().getPackageName());
            imageView.setImageResource(resourceId);
            tvName.setText(item.getName());

            return convertView;
        }
    }

}
