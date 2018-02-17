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
    private GridView makeGrid, typeGrid, recentGrid;
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

        if(null != MainActivity.vehicleJapaneseMakeIds && MainActivity.vehicleJapaneseMakeIds.getList().size() > 0){
            makeGrid.setAdapter(new vehicleIdsAdapter(MainActivity.vehicleJapaneseMakeIds.getList().subList(0, HOME_MAKE_VEHICLE_COUNT)));
        }

        if(null != MainActivity.vehicleTypeIds && MainActivity.vehicleTypeIds.getList().size() > 0){
            typeGrid.setAdapter(new vehicleIdsAdapter(MainActivity.vehicleTypeIds.getList().subList(0, HOME_TYPE_VEHICLE_COUNT)));
        }

        //populate recent view grid


        final BrandListAdapter.BrandItemClickListener itemClickListener = new BrandListAdapter.BrandItemClickListener() {
            @Override
            public void onItemClick(VehicleIds.Vehicle item) {
                //call api
                Toast.makeText(getActivity(), "item clicked" + item.getCategory(), Toast.LENGTH_SHORT).show();
            }
        };

        makeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               itemClickListener.onItemClick(MainActivity.vehicleJapaneseMakeIds.getList().get(position));
            }
        });

        typeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                itemClickListener.onItemClick(MainActivity.vehicleTypeIds.getList().get(position));
            }
        });

        return view;
    }

    private void setProperties() {
        btnViewAllMake.setOnClickListener(this);
        btnViewAllType.setOnClickListener(this);
        btnQuickSearch.setOnClickListener(this);
    }

    private void initViews() {
        btnViewAllMake = view.findViewById(R.id.btn_make_view_all);
        btnViewAllType = view.findViewById(R.id.btn_type_view_all);
        btnQuickSearch = view.findViewById(R.id.btn_quick_search);
        makeGrid = view.findViewById(R.id.make_grid);
        typeGrid = view.findViewById(R.id.type_grid);
        recentGrid = view.findViewById(R.id.recent_grid);
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

            case R.id.btn_quick_search:
                //
                break;
        }
    }

    private void loadBrandListScreen(String category) {
        FragmentUtils.addFragment(getActivity(), BrandListFragment.getInstance(category), "", true);
    }

    public class vehicleIdsAdapter extends BaseAdapter{
        private List<VehicleIds.Vehicle> itemList;
        private LayoutInflater inflater;
        private Resources resources;

        vehicleIdsAdapter(List<VehicleIds.Vehicle> itemList) {
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

            VehicleIds.Vehicle item = itemList.get(position);
            final int resourceId = resources.getIdentifier(item.getName(), "drawable", getActivity().getPackageName());
            brandImage.setImageResource(resourceId);
            tvName.setText(item.getName());

            return convertView;
        }
    }
}
