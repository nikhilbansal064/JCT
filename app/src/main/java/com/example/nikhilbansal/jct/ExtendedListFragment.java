package com.example.nikhilbansal.jct;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Nikhil Bansal on 13-01-2018.
 */

public class ExtendedListFragment extends BaseFragment {

    private View view;

    public static final String LIST_OF = "list_of";
    public static final String BY_MAKE = "make";
    public static final String BY_TYPE = "type";

    private RecyclerView rvList;
    private RvAdapter mAdapter;

    public static ExtendedListFragment getInstance(String showListOf){
        ExtendedListFragment extendedListFragment = new ExtendedListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LIST_OF, showListOf);
        extendedListFragment.setArguments(bundle);
        return extendedListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_extended_list, container, false);

        initViews();

        //populate list
        int[] ids;
        TypedArray tArray;
        if(getArguments().get(LIST_OF).toString().equalsIgnoreCase(BY_TYPE)){
            tArray = getResources().obtainTypedArray(R.array.type_list_ids);

        }else {
            tArray = getResources().obtainTypedArray(R.array.make_list_ids);
        }
        ids = new int[tArray.length()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = tArray.getResourceId(i, 0);
        }

        mAdapter = new RvAdapter(ids);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(mAdapter);
        return view;
    }

    private void initViews() {
        rvList = (RecyclerView) view.findViewById(R.id.rv_list);
    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>{

        int[] elementsIds;
        public RvAdapter(int[] ids) {
            elementsIds = ids;
        }

        @Override
        public RvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.element_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RvAdapter.MyViewHolder holder, int position) {
            holder.itemImage.setImageResource(elementsIds[position]);
        }

        @Override
        public int getItemCount() {
            return elementsIds.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ImageView itemImage;
            public MyViewHolder(View view) {
                super(view);
                itemImage = (ImageView) view.findViewById(R.id.list_item_image);
            }
        }
    }
}
