package com.example.fatimazza.thingapp.productlist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseFragment;

import butterknife.BindView;

public class ProductsFragment extends BaseFragment {

    @BindView(R.id.rv_products)
    public RecyclerView rvListOfProducts;

    @BindView(R.id.tv_error_message_display)
    public TextView tvErrorMsg;

    @BindView(R.id.pb_loading_indicator)
    public ProgressBar pbLoadingIndicator;

    @BindView(R.id.fab_add)
    public FloatingActionButton fabAdd;

    public ProductsFragment() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_products;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
