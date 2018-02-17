package com.example.nikhilbansal.jct;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Nikhil Bansal on 13-01-2018.
 */

public class BrandListFragment extends BaseFragment{

    private View view;
    public static final String CATEGORY = "category";
    public static final String BY_MAKE = "make";
    public static final String BY_TYPE = "type";

    private boolean japaneseMakerSelected = true;

    private RecyclerView brandList;
    private BrandListAdapter mAdapter;
    private Button btnJapaneseMaker, btnForeignMaker;
    private RelativeLayout layoutMakeCategorySwitch;

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
        setListeners();
        String vehicleCategory = getArguments().getString(CATEGORY);

        if(vehicleCategory.equalsIgnoreCase(BY_MAKE)){
            mAdapter = new BrandListAdapter(getActivity(), MainActivity.vehicleJapaneseMakeIds.getList());
            layoutMakeCategorySwitch.setVisibility(View.VISIBLE);
        }else{
            mAdapter = new BrandListAdapter(getActivity(), MainActivity.vehicleTypeIds.getList());
            layoutMakeCategorySwitch.setVisibility(View.GONE);
        }

        brandList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        brandList.setLayoutManager(layoutManager);
        brandList.setItemAnimator(new DefaultItemAnimator());
        brandList.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new BrandListAdapter.BrandItemClickListener() {
            @Override
            public void onItemClick(VehicleIds.Vehicle item) {
                //call api
                Toast.makeText(getActivity(), "item clicked" + item.getCategory(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void setListeners() {
        btnJapaneseMaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!japaneseMakerSelected){
                    ((Button)view).setTextColor(getResources().getColor(R.color.colorWhite));
                     view.setBackground(getResources().getDrawable(R.drawable.selected_tab_left_bg));

                     btnForeignMaker.setTextColor(getResources().getColor(R.color.colorBlack));
                     btnForeignMaker.setBackground(getResources().getDrawable(R.drawable.tab_right_bg));

                     japaneseMakerSelected = true;
                     mAdapter.updateDataSource(MainActivity.vehicleJapaneseMakeIds.getList());
                }
            }
        });

        btnForeignMaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(japaneseMakerSelected){
                    ((Button)view).setTextColor(getResources().getColor(R.color.colorWhite));
                    view.setBackground(getResources().getDrawable(R.drawable.selected_tab_right_bg));

                    btnJapaneseMaker.setTextColor(getResources().getColor(R.color.colorBlack));
                    btnJapaneseMaker.setBackground(getResources().getDrawable(R.drawable.tab_left_bg));

                    japaneseMakerSelected = false;
                    mAdapter.updateDataSource(MainActivity.vehicleForeignMakeIds.getList());
                }
            }
        });
    }

    private void initViews() {
        brandList = view.findViewById(R.id.rv_brand_list);
        btnJapaneseMaker = view.findViewById(R.id.btn_japanese_maker);
        btnForeignMaker = view.findViewById(R.id.btn_foreign_maker);
        layoutMakeCategorySwitch = view.findViewById(R.id.make_category_switch_container);

    }
}
