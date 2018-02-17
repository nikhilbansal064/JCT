package com.example.nikhilbansal.jct.dealer_list;

import android.view.View;

import com.example.nikhilbansal.jct.dealer_list.Model.DealerListResponse;

/**
 * Created by Nikhil Bansal on 16-02-2018.
 */

public interface ItemClickListener {
    public void OnItemClick(DealerListResponse.DealerInfo dealer);
}
