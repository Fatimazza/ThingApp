package com.example.fatimazza.thingapp.home;

import com.example.fatimazza.thingapp.base.BasePresenter;
import com.example.fatimazza.thingapp.network.ProductAPIServices;

public class HomePresenter extends BasePresenter<HomeContract.View>
        implements HomeContract.Presenter {

    public HomePresenter(ProductAPIServices productAPIServices) {
        super(productAPIServices);
    }
}
