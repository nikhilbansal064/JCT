package com.example.nikhilbansal.jct.dealer_list;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.dealer_list.Model.DealerListRequest;
import com.example.nikhilbansal.jct.dealer_list.Model.DealerListResponse;

/**
 * Created by Nikhil Bansal on 02-02-2018.
 */

public interface DealerListInterface {

    public interface IDealerListView{
        public void dealerListSuccess(DealerListResponse dealerListResponse);
        public void dealerListFailure(String message);
    }

    public interface IDealerListPresenter{
        public void callDealerListApi(DealerListRequest request);
    }

    public interface IDealerListInteractor{
        public void getDealerList(DealerListRequest request, ApiCallback callback);
    }
}
