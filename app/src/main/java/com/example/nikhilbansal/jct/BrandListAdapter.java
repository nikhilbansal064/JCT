package com.example.nikhilbansal.jct;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nikhil Bansal on 20-01-2018.
 */

class BrandListAdapter extends RecyclerView.Adapter<BrandListAdapter.MyViewHolder>{

    private List<VehicleIds.Vehicle> itemList;
    private LayoutInflater inflater;
    private Resources resources;
    private Context context;
    private BrandItemClickListener itemClickListener;

    public BrandListAdapter(Context context, List<VehicleIds.Vehicle> itemList) {
        this.itemList = itemList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resources = context.getResources();
        this.context = context;
    }

    @Override
    public BrandListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.element_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BrandListAdapter.MyViewHolder holder, int position) {
        VehicleIds.Vehicle item = itemList.get(position);
        final int resourceId = resources.getIdentifier(item.getName(), "drawable", context.getPackageName());
        holder.brandImage.setImageResource(resourceId);
        holder.brandName.setText(item.getName());
        holder.bindItemClickListener(item, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView brandImage;
        private TextView brandName;

        public MyViewHolder(View view) {
            super(view);
            brandImage = view.findViewById(R.id.iv_brand_image);
            brandName = view.findViewById(R.id.tv_brand_name);
        }

        public void bindItemClickListener(final VehicleIds.Vehicle item, final BrandItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public void updateDataSource(List<VehicleIds.Vehicle> dataSet){
        itemList = dataSet;
        notifyDataSetChanged();
    }

    public void setItemClickListener(BrandItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface BrandItemClickListener{
        void onItemClick(VehicleIds.Vehicle item);
    }
}

