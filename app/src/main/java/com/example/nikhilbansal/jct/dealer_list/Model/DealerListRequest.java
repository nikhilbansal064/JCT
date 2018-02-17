package com.example.nikhilbansal.jct.dealer_list.Model;

/**
 * Created by Nikhil Bansal on 02-02-2018.
 */

public class DealerListRequest {
    private String action;
    private String dealerListType;
    private int page;
    private int sorting;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDealerListType() {
        return dealerListType;
    }

    public void setDealerListType(String dealerListType) {
        this.dealerListType = dealerListType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }
}
