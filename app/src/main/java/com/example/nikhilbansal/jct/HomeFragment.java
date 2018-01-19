package com.example.nikhilbansal.jct;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import java.util.List;

/**
 * Created by Nikhil Bansal on 09-01-2018.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ImageView btnViewAllMake, btnViewAllType, btnQuickSearch;
    private GridView makeGrid, typeGrid;
    private View view;

    private static final String VEHICLE_BY_MAKE = "make";
    private static final String VEHICLE_BY_TYPE = "type";
    private static final int HOME_TYPE_VEHICLE_COUNT = 4;
    private static final int HOME_MAKE_VEHICLE_COUNT = 8;


    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews();
        setProperties();

        if(null != MainActivity.vehicleMakeIds && MainActivity.vehicleMakeIds.getList().size() > 0){
            makeGrid.setAdapter(new vehicleIdsAdapter(MainActivity.vehicleMakeIds.getList().subList(0, HOME_MAKE_VEHICLE_COUNT)));
        }

        if(null != MainActivity.vehicleTypeIds && MainActivity.vehicleTypeIds.getList().size() > 0){
            typeGrid.setAdapter(new vehicleIdsAdapter(MainActivity.vehicleTypeIds.getList().subList(0, HOME_TYPE_VEHICLE_COUNT)));
        }

        makeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "make item clicked", Toast.LENGTH_SHORT).show();
            }
        });

        typeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "type item clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void setProperties() {
        btnViewAllMake.setOnClickListener(this);
        btnViewAllType.setOnClickListener(this);
    }

    private void initViews() {
        btnViewAllMake = view.findViewById(R.id.btn_make_view_all);
        btnViewAllType = view.findViewById(R.id.btn_type_view_all);
        makeGrid = view.findViewById(R.id.make_grid);
        typeGrid = view.findViewById(R.id.type_grid);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_make_view_all:
                loadBrandListScreen(VEHICLE_BY_MAKE);
                break;
            case R.id.btn_type_view_all:
                loadBrandListScreen(VEHICLE_BY_TYPE);
                break;
        }
    }

    private void loadBrandListScreen(String category) {
        FragmentUtils.addFragment(getActivity(), BrandListFragment.getInstance(BrandListFragment.BY_TYPE), "", true);
    }


    public class vehicleIdsAdapter extends BaseAdapter{
        private List<VehicleIds.vehicle> itemList;
        private LayoutInflater inflater;
        private Resources resources;

        public vehicleIdsAdapter(List<VehicleIds.vehicle> itemList) {
            this.itemList = itemList;
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            resources = getResources();
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ImageView brandImage;
            TextView tvName;

            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                convertView = inflater.inflate(R.layout.layout_grid_item, viewGroup, false);
            }

            brandImage = convertView.findViewById(R.id.iv_brand_image);
            tvName = convertView.findViewById(R.id.tv_brand_name);

            VehicleIds.vehicle item = itemList.get(position);
            final int resourceId = resources.getIdentifier(item.getName(), "drawable", getActivity().getPackageName());
            brandImage.setImageResource(resourceId);
            tvName.setText(item.getName());

            return convertView;
        }
    }

}
