package com.example.fatimazza.thingapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        View rootView;

        @BindView(R.id.iv_product_thumbnail)
        ImageView ivProductThumb;

        @BindView(R.id.tv_product_title)
        TextView tvProductTitle;

        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;

        @BindView(R.id.tv_product_desc)
        TextView tvProductDesc;

        public HomeAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.rootView = itemView;
        }
        
    }
}
