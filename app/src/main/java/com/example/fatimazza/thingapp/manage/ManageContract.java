package com.example.fatimazza.thingapp.manage;

import com.example.fatimazza.thingapp.base.BaseContractView;

public interface ManageContract {

    interface View extends BaseContractView {

        void initPresenter();

        void bindViewToPresenter();

        void showErrorLog(Throwable throwable);

        void showErrorMessage();

        void showSuccessMessage();

    }

    interface Presenter {

        void addProduct(String productName, long productPrice, String productDesc);

    }
}
