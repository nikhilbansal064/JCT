package com.example.nikhilbansal.jct;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nikhil Bansal on 13-01-2018.
 */

public class BrandListFragment extends BaseFragment {

    private View view;
    public static final String CATEGORY = "category";
    public static final String BY_MAKE = "make";
    public static final String BY_TYPE = "type";

    private RecyclerView brandList;
    private RvAdapter mAdapter;

    public static BrandListFragment getInstance(String category){
        BrandListFragment extendedListFragment = new BrandListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY, category);
        extendedListFragment.setArguments(bundle);
        return extendedListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_brand_list, container, false);

        initViews();
        String vehicleCategory = getArguments().getString(CATEGORY);
        if(vehicleCategory.equalsIgnoreCase(BY_MAKE)){
            mAdapter = new RvAdapter(MainActivity.vehicleMakeIds.getList());
        }else{

            mAdapter = new RvAdapter(MainActivity.vehicleTypeIds.getList());
        }
        brandList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        brandList.setLayoutManager(layoutManager);
        brandList.setItemAnimator(new DefaultItemAnimator());
        brandList.setAdapter(mAdapter);
        return view;
    }

    private void initViews() {
        brandList = (RecyclerView) view.findViewById(R.id.rv_brand_list);
    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>{
        private List<VehicleIds.vehicle> itemList;
        private LayoutInflater inflater;
        private Resources resources;

        public RvAdapter(List<VehicleIds.vehicle> itemList) {
            this.itemList = itemList;
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            resources = getResources();
        }

        @Override
        public RvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView =inflater.inflate(R.layout.element_list_row, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RvAdapter.MyViewHolder holder, int position) {
            VehicleIds.vehicle item = itemList.get(position);
            final int resourceId = resources.getIdentifier(item.getName(), "drawable", getActivity().getPackageName());
            holder.brandImage.setImageResource(resourceId);
            holder.brandName.setText(item.getName());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private ImageView brandImage;
            private TextView brandName;

            public MyViewHolder(View view) {
                super(view);
                brandImage = view.findViewById(R.id.iv_brand_image);
                brandName = view.findViewById(R.id.tv_brand_name);
            }
        }
    }
}
