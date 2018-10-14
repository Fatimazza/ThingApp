package com.example.fatimazza.thingapp.productlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsAdapterViewHolder> {

    private String [] mProducts = { "Product1", "Product2", "Product3" };

    @Override
    public ProductsAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_list_item, viewGroup, false);
        return new ProductsAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductsAdapterViewHolder holder, int position) {
        holder.tvProductTitle.setText(mProducts[position]);
        holder.tvProductPrice.setText(mProducts[position]);
        holder.tvProductDesc.setText(mProducts[position]);
    }

    @Override
    public int getItemCount() {
        if (null == mProducts) return 0;
        return mProducts.length;

    }

    class ProductsAdapterViewHolder extends RecyclerView.ViewHolder{

        View rootView;

        @BindView(R.id.iv_product_thumbnail)
        ImageView ivProductThumb;

        @BindView(R.id.tv_product_title)
        TextView tvProductTitle;

        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;

        @BindView(R.id.tv_product_desc)
        TextView tvProductDesc;

        public ProductsAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.rootView = itemView;
        }
    }

}
