package com.example.fatimazza.thingapp.productlist;

import com.example.fatimazza.thingapp.base.BaseContractView;

public interface ProductFragmentContract {

    interface View extends BaseContractView {

        void initComponent();


        void showLoading();

        void showListOfProducts();

        void showErrorLog(Throwable throwable);

        void showErrorMessage();

        void startLoadProduct();

    }

    interface Presenter {

    }
}
