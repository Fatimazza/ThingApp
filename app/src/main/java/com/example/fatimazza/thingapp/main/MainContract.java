package com.example.fatimazza.thingapp.main;

import com.example.fatimazza.thingapp.base.BaseContractView;
import com.example.fatimazza.thingapp.base.BaseFragment;

public interface MainContract {

    interface View extends BaseContractView {
        
        void setFragment(BaseFragment fragment);

    }

    interface Presenter {

    }
}

