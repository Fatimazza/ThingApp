package com.example.fatimazza.thingapp.base;

public class FragmentContract {

    interface View extends BaseContractView {

        void attachPresenter(Presenter presenter);

    }

    interface Presenter {

        void addFragment(BaseFragment fragment);

    }
}
