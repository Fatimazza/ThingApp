package com.example.fatimazza.thingapp.productlist;

import com.example.fatimazza.thingapp.base.BasePresenter;
import com.example.fatimazza.thingapp.model.ProductDAO;
import com.example.fatimazza.thingapp.network.ProductAPIServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsPresenter extends BasePresenter<ProductFragmentContract.View>
        implements ProductFragmentContract.Presenter {

    public ProductsPresenter(ProductAPIServices productAPIServices) {
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
