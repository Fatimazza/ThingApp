package com.example.fatimazza.thingapp.manage;

import com.example.fatimazza.thingapp.base.BasePresenter;
import com.example.fatimazza.thingapp.network.ProductAPIServices;

public class ManagePresenter extends BasePresenter<ManageContract.View>
        implements ManageContract.Presenter {

    public ManagePresenter(ProductAPIServices productAPIServices) {
        super(productAPIServices);
    }

    @Override
    public void addProduct(String productName, long productPrice, String productDesc) {

    }
}
