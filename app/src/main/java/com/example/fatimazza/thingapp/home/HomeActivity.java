package com.example.fatimazza.thingapp.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.rv_products)
    public RecyclerView rvListOfProducts;

    @BindView(R.id.tv_error_message_display)
    public TextView tvErrorMsg;

    @BindView(R.id.pb_loading_indicator)
    public ProgressBar pbLoadingIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showLoading();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    private void showLoading() {
        pbLoadingIndicator.setVisibility(View.VISIBLE);
        rvListOfProducts.setVisibility(View.GONE);
    }

    private void showListOfProducts() {
        tvErrorMsg.setVisibility(View.GONE);
        rvListOfProducts.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        tvErrorMsg.setVisibility(View.VISIBLE);
        rvListOfProducts.setVisibility(View.GONE);
    }

}
