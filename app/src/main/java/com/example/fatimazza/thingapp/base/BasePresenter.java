package com.example.fatimazza.thingapp.base;

import com.example.fatimazza.thingapp.network.ProductAPIServices;

public class BasePresenter<T extends BaseContractView> {

    private T mvpView;

    ProductAPIServices productAPIServices;

    public BasePresenter(ProductAPIServices productAPIServices) {
        this.productAPIServices = productAPIServices;
    }

    public T getMvpView() {
        return mvpView;
    }

    public void setMvpView(T mvpView) {
        this.mvpView = mvpView;
    }
}
