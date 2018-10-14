package com.example.fatimazza.thingapp.productadd;

import com.example.fatimazza.thingapp.base.BaseContractView;

public interface AddProductFragmentContract {

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
