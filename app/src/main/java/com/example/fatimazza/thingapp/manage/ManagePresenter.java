package com.example.fatimazza.thingapp.manage;

import com.example.fatimazza.thingapp.base.BasePresenter;
import com.example.fatimazza.thingapp.model.ProductDAO;
import com.example.fatimazza.thingapp.network.ProductAPIServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagePresenter extends BasePresenter<ManageContract.View>
        implements ManageContract.Presenter {

    public ManagePresenter(ProductAPIServices productAPIServices) {
        super(productAPIServices);
    }

    @Override
    public void addProduct(String productName, long productPrice, String productDesc) {
        getProductAPIServices()
                .addProduct(productName, productPrice, productDesc)
                .enqueue(new Callback<ProductDAO>() {
                    @Override
                    public void onResponse(Call<ProductDAO> call, Response<ProductDAO> response) {
                        getMvpView().showSuccessMessage();
                    }

                    @Override
                    public void onFailure(Call<ProductDAO> call, Throwable t) {
                        getMvpView().showErrorLog(t);
                        getMvpView().showErrorMessage();
                    }
                });
    }
}
