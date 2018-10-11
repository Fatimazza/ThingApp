package com.example.fatimazza.thingapp.home;

import com.example.fatimazza.thingapp.base.BaseContractView;
import com.example.fatimazza.thingapp.model.ProductDAO;

import java.util.List;

import retrofit2.Response;

public interface HomeContract {

    interface View extends BaseContractView {

        void initComponent();

        void initPresenter();

        void bindViewToPresenter();

        void showLoading();

        void showListOfProducts();

        void showErrorLog(Throwable throwable);

        void showErrorMessage();

        void startLoadProduct();

        void finishLoadProduct(Response<List<ProductDAO>> response);

    }

    interface Presenter {

        void loadProduct();

    }
}
