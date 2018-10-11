package com.example.fatimazza.thingapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.model.ProductDAO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>{

    private List<ProductDAO> dataProducts = new ArrayList<>();

    private Context context;

    public HomeAdapter(Context context, List<ProductDAO> dataProducts) {
        this.context = context;
        this.dataProducts = dataProducts;
    }

    @Override
    public HomeAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(
                R.layout.product_list_item, viewGroup, false);
        return new HomeAdapterViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(HomeAdapterViewHolder holder, int position) {
        final ProductDAO dataItemProduct = dataProducts.get(position);
        holder.tvProductTitle.setText(dataItemProduct.getName());
        holder.tvProductPrice.setText(String.valueOf(dataItemProduct.getPrice()));
        holder.tvProductDesc.setText(dataItemProduct.getDescription());
    }

    @Override
    public int getItemCount() {
        if (null == dataProducts) return 0;
        return dataProducts.size();

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
