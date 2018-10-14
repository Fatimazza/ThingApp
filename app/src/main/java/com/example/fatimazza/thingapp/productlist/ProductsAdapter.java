package com.example.fatimazza.thingapp.productlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fatimazza.thingapp.R;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsAdapterViewHolder> {

    private String [] mProducts = { "Product1", "Product2", "Product3" };

    @Override
    public ProductsAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_list_item, viewGroup, false);
        return new ProductsAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductsAdapterViewHolder productsAdapterViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        if (null == mProducts) return 0;
        return mProducts.length;

    }

    class ProductsAdapterViewHolder extends RecyclerView.ViewHolder{

        public ProductsAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
