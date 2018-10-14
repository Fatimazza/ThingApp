package com.example.fatimazza.thingapp.manage;

import com.example.fatimazza.thingapp.base.BaseContractView;

public interface ManageContract {

    interface View extends BaseContractView {

        void initPresenter();

        void bindViewToPresenter();

    }

    interface Presenter {

    }
}
