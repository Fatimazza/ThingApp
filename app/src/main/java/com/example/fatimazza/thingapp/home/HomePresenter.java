package com.example.fatimazza.thingapp.home;

import com.example.fatimazza.thingapp.base.BasePresenter;
import com.example.fatimazza.thingapp.model.ProductDAO;
import com.example.fatimazza.thingapp.network.ProductAPIServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter extends BasePresenter<HomeContract.View>
        implements HomeContract.Presenter {

    public HomePresenter(ProductAPIServices productAPIServices) {
        super(productAPIServices);
    }

    @Override
    public void loadProduct() {
        getProductAPIServices()
                .fetchProducts()
                .enqueue(new Callback<List<ProductDAO>>() {
                    @Override
                    public void onResponse(Call<List<ProductDAO>> call, Response<List<ProductDAO>> response) {
                        if (response.body() != null) {
                            getMvpView().finishLoadProduct(response);
                            getMvpView().showListOfProducts();
                        } else {
                            getMvpView().showErrorMessage();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ProductDAO>> call, Throwable t) {
                        getMvpView().showErrorLog(t);
                        getMvpView().showErrorMessage();
                    }
                });
    }
}
