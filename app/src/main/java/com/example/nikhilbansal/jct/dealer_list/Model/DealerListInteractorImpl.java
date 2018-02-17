package com.example.nikhilbansal.jct.dealer_list.Model;

import com.example.nikhilbansal.jct.ApiCallback;
import com.example.nikhilbansal.jct.api.ApiManagement;
import com.example.nikhilbansal.jct.dealer_list.DealerListInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil Bansal on 16-02-2018.
 */

public class DealerListInteractorImpl implements DealerListInterface.IDealerListInteractor {
    private DealerListPresenterImpl mPresenter;

    public DealerListInteractorImpl(DealerListPresenterImpl mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void getDealerList(DealerListRequest request, final ApiCallback callback) {

        final Map<String, String> requestMap = new HashMap<>();
        requestMap.put("action", request.getAction());
        requestMap.put("listType", request.getDealerListType());
        requestMap.put("page", String.valueOf(request.getPage()));
        requestMap.put("st", String.valueOf(request.getSorting()));

        ApiManagement.getDealerList(requestMap, new ApiCallback() {
            @Override
            public void onSuccess(Object response) {
                callback.onSuccess(response);
            }

            @Override
            public void onFailure(String failureMsg) {
                callback.onFailure(failureMsg);
            }
        });
    }
}
