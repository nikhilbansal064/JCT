package com.example.nikhilbansal.jct.dealer_list.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nikhil Bansal on 02-02-2018.
 */

public class DealerListResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total_records")
    @Expose
    private String totalRecords;
    @SerializedName("logo_url")
    @Expose
    private String logoUrl;
    @SerializedName("no_logo_url")
    @Expose
    private String noLogoUrl;
    @SerializedName("data")
    @Expose
    private List<DealerInfo> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getNoLogoUrl() {
        return noLogoUrl;
    }

    public void setNoLogoUrl(String noLogoUrl) {
        this.noLogoUrl = noLogoUrl;
    }

    public List<DealerInfo> getData() {
        return data;
    }

    public void setData(List<DealerInfo> data) {
        this.data = data;
    }

    public class DealerInfo {
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("orgIds")
        @Expose
        private String orgIds;
        @SerializedName("noOfStocks")
        @Expose
        private String noOfStocks;
        @SerializedName("hits")
        @Expose
        private String hits;
        @SerializedName("company")
        @Expose
        private String company;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("membership_type")
        @Expose
        private String membershipType;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getOrgIds() {
            return orgIds;
        }

        public void setOrgIds(String orgIds) {
            this.orgIds = orgIds;
        }

        public String getNoOfStocks() {
            return noOfStocks;
        }

        public void setNoOfStocks(String noOfStocks) {
            this.noOfStocks = noOfStocks;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMembershipType() {
            return membershipType;
        }

        public void setMembershipType(String membershipType) {
            this.membershipType = membershipType;
        }
    }
}
