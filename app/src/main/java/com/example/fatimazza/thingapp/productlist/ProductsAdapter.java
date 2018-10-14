package com.example.fatimazza.thingapp.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.model.ProductDAO;
import com.example.fatimazza.thingapp.model.ProductImageDAO;
import com.example.fatimazza.thingapp.utils.PicassoCacheHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsAdapterViewHolder> {

    private Context context;

    private List<ProductDAO> dataProducts = new ArrayList<>();

    public ProductsAdapter(Context context, List<ProductDAO> dataProducts) {
        this.context = context;
        this.dataProducts = dataProducts;
    }

    @Override
    public ProductsAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_list_item, viewGroup, false);
        return new ProductsAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductsAdapterViewHolder holder, int position) {

        final ProductDAO dataItemProduct = dataProducts.get(position);
        final Context context = holder.rootView.getContext();

        holder.tvProductTitle.setText(dataItemProduct.getName());
        holder.tvProductPrice.setText(String.valueOf("$ " +dataItemProduct.getPrice()));
        holder.tvProductDesc.setText(dataItemProduct.getDescription());

        List<ProductImageDAO> imagesOfProducts = dataProducts.get(position).getImages();

        if(!imagesOfProducts.isEmpty()) {
            String imagePath = imagesOfProducts.get(0).getThumb();
            PicassoCacheHelper.getInstance(context)
                    .load(imagePath)
                    .placeholder(R.color.grey)
                    .error(R.color.grey)
                    .into(holder.ivProductThumb);
        }
    }

    @Override
    public int getItemCount() {
        if (null == dataProducts) return 0;
        return dataProducts.size();

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
