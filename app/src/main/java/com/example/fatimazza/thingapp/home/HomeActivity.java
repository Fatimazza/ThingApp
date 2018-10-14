package com.example.fatimazza.thingapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;
import com.example.fatimazza.thingapp.manage.ManageActivity;
import com.example.fatimazza.thingapp.model.ProductDAO;
import com.example.fatimazza.thingapp.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Response;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.rv_products)
    public RecyclerView rvListOfProducts;

    @BindView(R.id.tv_error_message_display)
    public TextView tvErrorMsg;

    @BindView(R.id.pb_loading_indicator)
    public ProgressBar pbLoadingIndicator;

    @BindView(R.id.fab_add)
    public FloatingActionButton fabAdd;

    private HomeAdapter homeAdapter;

    private HomePresenter homePresenter;

    private List<ProductDAO> dataProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initComponent();
        initPresenter();
        bindViewToPresenter();

        loadAllProducts();
    }

    private void loadAllProducts() {
        showLoading();
        startLoadProduct();
    }

    @Override
    public void initComponent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListOfProducts.setLayoutManager(linearLayoutManager);
        rvListOfProducts.setHasFixedSize(true);

        homeAdapter = new HomeAdapter(this, dataProducts);
        rvListOfProducts.setAdapter(homeAdapter);
    }

    @Override
    public void initPresenter() {
        homePresenter = new HomePresenter(RetrofitHelper.getInstance().getProductAPIServices());
    }

    @Override
    public void bindViewToPresenter() {
        homePresenter.setMvpView(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void startLoadProduct() {
        homePresenter.loadProduct();
    }

    @Override
    public void finishLoadProduct(Response<List<ProductDAO>> response) {
        dataProducts.clear();
        dataProducts.addAll(response.body());
        homeAdapter.notifyDataSetChanged();
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

    public void addNewThingToList (View view) {
            Intent intent = new Intent(this, ManageActivity.class);
            startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAllProducts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.setMvpView(null);
    }
}
