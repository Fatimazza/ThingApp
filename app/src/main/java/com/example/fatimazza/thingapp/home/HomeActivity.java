package com.example.fatimazza.thingapp.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;
import com.example.fatimazza.thingapp.model.ProductDAO;
import com.example.fatimazza.thingapp.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.rv_products)
    public RecyclerView rvListOfProducts;

    @BindView(R.id.tv_error_message_display)
    public TextView tvErrorMsg;

    @BindView(R.id.pb_loading_indicator)
    public ProgressBar pbLoadingIndicator;

    private HomeAdapter homeAdapter;

    private List<ProductDAO> dataProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initComponent();

        showLoading();
        loadProduct();
    }

    private void initComponent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListOfProducts.setLayoutManager(linearLayoutManager);
        rvListOfProducts.setHasFixedSize(true);

        homeAdapter = new HomeAdapter(this, dataProducts);
        rvListOfProducts.setAdapter(homeAdapter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    private void loadProduct() {
        RetrofitHelper.getInstance().getProductAPIServices()
                .fetchProducts()
                .enqueue(new Callback<List<ProductDAO>>() {
                    @Override
                    public void onResponse(Call<List<ProductDAO>> call, Response<List<ProductDAO>> response) {
                        if (response.body() != null) {
                            dataProducts.clear();
                            dataProducts.addAll(response.body());
                            homeAdapter.notifyDataSetChanged();
                            showListOfProducts();
                        } else {
                            showErrorMessage();
                        }
                        pbLoadingIndicator.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<List<ProductDAO>> call, Throwable t) {
                        Log.d("retroFailure ", t.getMessage());
                        showErrorMessage();
                        pbLoadingIndicator.setVisibility(View.GONE);
                    }
                });

    }

    @Override
    public void showLoading() {
        pbLoadingIndicator.setVisibility(View.VISIBLE);
        rvListOfProducts.setVisibility(View.GONE);
    }

    @Override
    public void showListOfProducts() {
        tvErrorMsg.setVisibility(View.GONE);
        rvListOfProducts.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage() {
        tvErrorMsg.setVisibility(View.VISIBLE);
        rvListOfProducts.setVisibility(View.GONE);
    }

}
