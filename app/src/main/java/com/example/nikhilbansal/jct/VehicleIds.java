package com.example.nikhilbansal.jct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nikhil Bansal on 19-01-2018.
 */

public class VehicleIds {

    @SerializedName("list")
    @Expose
    private ArrayList<vehicle> list;

    public ArrayList<vehicle> getList() {
        return list;
    }

    public void setList(ArrayList<vehicle> list) {
        this.list = list;
    }

    public class vehicle {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("category")
        @Expose
        private String category;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }
}