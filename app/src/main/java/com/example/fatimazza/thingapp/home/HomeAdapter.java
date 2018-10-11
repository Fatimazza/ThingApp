package com.example.fatimazza.thingapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>{

    private String [] mProducts = { "Product1", "Product2", "Product3" };

    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public HomeAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(
                R.layout.product_list_item, viewGroup, false);
        return new HomeAdapterViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(HomeAdapterViewHolder holder, int position) {
        String dummyData = mProducts[position];
        holder.tvProductTitle.setText(dummyData);
        holder.tvProductPrice.setText(dummyData);
        holder.tvProductDesc.setText(dummyData);
    }

    @Override
    public int getItemCount() {
        if (null == mProducts) return 0;
        return mProducts.length;

    }

    void setListOfProductData(String[] mProductsDummy) {
        mProducts = mProductsDummy;
        notifyDataSetChanged();
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
