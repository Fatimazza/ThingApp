package com.example.fatimazza.thingapp.productlist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseFragment;
import com.example.fatimazza.thingapp.home.HomeAdapter;
import com.example.fatimazza.thingapp.productadd.AddProductFragment;

import butterknife.BindView;

public class ProductsFragment extends BaseFragment implements ProductFragmentContract.View {

    @BindView(R.id.rv_products)
    public RecyclerView rvListOfProducts;

    @BindView(R.id.tv_error_message_display)
    public TextView tvErrorMsg;

    @BindView(R.id.pb_loading_indicator)
    public ProgressBar pbLoadingIndicator;

    @BindView(R.id.fab_add)
    public FloatingActionButton fabAdd;

    ProductsAdapter productsAdapter;

    public ProductsFragment() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_products;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponent();
        fabAdd.setOnClickListener(this);

        loadAllProducts();
    }

    private void loadAllProducts() {
        showLoading();
        startLoadProduct();
    }

    @Override
    public void startLoadProduct() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_add:
                fragmentContractPresenter.addFragment(new AddProductFragment());
                break;
        }
    }

    @Override
    public void initComponent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvListOfProducts.setLayoutManager(linearLayoutManager);
        rvListOfProducts.setHasFixedSize(true);

        productsAdapter = new ProductsAdapter();
        rvListOfProducts.setAdapter(productsAdapter);
    }

    @Override
    public void showLoading() {
        pbLoadingIndicator.setVisibility(View.VISIBLE);
        rvListOfProducts.setVisibility(View.GONE);
    }

    @Override
    public void showListOfProducts() {
        pbLoadingIndicator.setVisibility(View.GONE);
        tvErrorMsg.setVisibility(View.GONE);
        rvListOfProducts.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage() {
        pbLoadingIndicator.setVisibility(View.GONE);
        tvErrorMsg.setVisibility(View.VISIBLE);
        rvListOfProducts.setVisibility(View.GONE);
    }

    @Override
    public void showErrorLog(Throwable throwable) {
        Log.d("retroFailure ", throwable.getMessage());
    }
}
