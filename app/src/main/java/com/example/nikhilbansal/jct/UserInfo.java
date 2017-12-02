package com.example.nikhilbansal.jct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class UserInfo {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("sess_id")
    @Expose
    private String sessId;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("tlt")
    @Expose
    private String tlt;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("address_1")
    @Expose
    private String address1;
    @SerializedName("address_2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("telephone_1")
    @Expose
    private String telephone1;
    @SerializedName("telephone_2")
    @Expose
    private String telephone2;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("port_of_dest")
    @Expose
    private String portOfDest;

    private String isNewsLetter;
    private String email2;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSessId() {
        return sessId;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTlt() {
        return tlt;
    }

    public void setTlt(String tlt) {
        this.tlt = tlt;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPortOfDest() {
        return portOfDest;
    }

    public void setPortOfDest(String portOfDest) {
        this.portOfDest = portOfDest;
    }

    public String getIsNewsLetter() {
        return isNewsLetter;
    }

    public void setIsNewsLetter(String isNewsLetter) {
        this.isNewsLetter = isNewsLetter;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
}
