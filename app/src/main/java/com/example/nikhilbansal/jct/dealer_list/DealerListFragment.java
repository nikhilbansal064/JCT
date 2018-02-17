package com.example.nikhilbansal.jct.dealer_list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nikhilbansal.jct.BaseFragment;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.constant.ApiConstants;
import com.example.nikhilbansal.jct.dealer_list.Model.DealerListPresenterImpl;
import com.example.nikhilbansal.jct.dealer_list.Model.DealerListRequest;
import com.example.nikhilbansal.jct.dealer_list.Model.DealerListResponse;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil Bansal on 21-01-2018.
 */

public class DealerListFragment extends BaseFragment implements DealerListInterface.IDealerListView {

    private View view;
    private RecyclerView rvDealerList;
    private DealerListResponse dealerListResponse;
    private LinearLayoutManager linearLayoutManager;
    private DealerListPresenterImpl mPresenter;
    private ItemClickListener clickListener;
    private List<DealerListResponse.DealerInfo> dealerList = new ArrayList<>();

    public static DealerListFragment newInstance(){
        return new DealerListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dealer_list, container, false);
        mPresenter = new DealerListPresenterImpl(this);

        //call dealer list API
        showLoading(getContext());
        //create dealer list request
        DealerListRequest request = new DealerListRequest();
        request.setAction(ApiConstants.API_EX_IMP_LIST_ACTION);
        request.setDealerListType("e");
        request.setPage(1);
        request.setSorting(1);
        mPresenter.callDealerListApi(request);


        initViews();

        clickListener = new ItemClickListener() {
            @Override
            public void OnItemClick(DealerListResponse.DealerInfo dealer) {
                //open dealer detail fragment
            }
        };



        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvDealerList.setLayoutManager(linearLayoutManager);
        rvDealerList.setItemAnimator(new DefaultItemAnimator());
        rvDealerList.setAdapter(new DealerListAdapter(clickListener, dealerList));
        rvDealerList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


            }
        });
        return view;
    }

    private void initViews() {
        rvDealerList = view.findViewById(R.id.rv_dealer_list);
    }

    @Override
    public void dealerListSuccess(DealerListResponse dealerListResponse) {
        //load recycler view
        hideLoading();
        this.dealerListResponse = dealerListResponse;
        dealerList.addAll(dealerListResponse.getData());
    }

    @Override
    public void dealerListFailure(String message) {
        //show error message
        hideLoading();
    }


    //adapter
    private class DealerListAdapter extends RecyclerView.Adapter<DealerListAdapter.MyViewHolder> {

        private LayoutInflater inflater;
        private ItemClickListener clickListener;
        private Context context = getActivity();
        private List<DealerListResponse.DealerInfo> dealerList;

        public DealerListAdapter(ItemClickListener listener, List<DealerListResponse.DealerInfo> dealerList) {
            clickListener = listener;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.dealerList = dealerList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_dealer_list, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            DealerListResponse.DealerInfo dealer = dealerList.get(position);

            holder.name.setText(dealer.getCompany());
            holder.location.setText(dealer.getCity() + ", " + dealer.getCountry());
            holder.dealsIn.setText(dealer.getHits()); //need to change
            //load pic code
            holder.bindClickListener(clickListener, dealerList.get(position));
        }

        @Override
        public int getItemCount() {
            return dealerList != null ? dealerList.size() : 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView name, location, dealsIn;
            public ImageView logo;

            public MyViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.tv_dealer_name);
                location = itemView.findViewById(R.id.tv_location);
                dealsIn = itemView.findViewById(R.id.tv_deals_in_value);
                logo = itemView.findViewById(R.id.iv_dealer_logo);
            }

            public void bindClickListener(final ItemClickListener listener, final DealerListResponse.DealerInfo dealer){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.OnItemClick(dealer);
                    }
                });
            }
        }
    }
}
