package com.example.nikhilbansal.jct.dealer_list.Model;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.dealer_list.DealerListInterface;

/**
 * Created by Nikhil Bansal on 16-02-2018.
 */

public class DealerListPresenterImpl implements DealerListInterface.IDealerListPresenter {
    private DealerListInterface.IDealerListView mView;
    private DealerListInteractorImpl mInteractor;

    public DealerListPresenterImpl(DealerListInterface.IDealerListView mView) {
        this.mView = mView;
        this.mInteractor = new DealerListInteractorImpl(this);
    }

    @Override
    public void callDealerListApi(final DealerListRequest request) {
        mInteractor.getDealerList(request, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response instanceof DealerListResponse){
                    mView.dealerListSuccess((DealerListResponse)response);
                }
            }

            @Override
            public void onFailure(String failureMsg) {
                mView.dealerListFailure(failureMsg);
            }
        });
    }
}
