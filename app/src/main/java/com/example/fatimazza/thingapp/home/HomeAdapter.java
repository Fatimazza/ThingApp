package com.example.fatimazza.thingapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>{

    private String [] mProducts = { "Product1", "Product2", "Product3" };


    @Override
    public HomeAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HomeAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (null == mProducts) return 0;
        return mProducts.length;

    }

    class HomeAdapterViewHolder extends RecyclerView.ViewHolder {

        public HomeAdapterViewHolder(View itemView) {
            super(itemView);
        }
        
    }
}
