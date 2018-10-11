package com.example.fatimazza.thingapp.home;

import com.example.fatimazza.thingapp.base.BaseContractView;

public interface HomeContract {

    interface View extends BaseContractView {

        void initComponent();

        void initPresenter();

        void bindViewToPresenter();

        void showLoading();

        void showListOfProducts();

        void showErrorMessage();

    }

    interface Presenter {

    }
}
