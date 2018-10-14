package com.example.fatimazza.thingapp.main;

import com.example.fatimazza.thingapp.base.BaseFragment;
import com.example.fatimazza.thingapp.base.FragmentContract;

public class MainPresenter implements MainContract.Presenter, FragmentContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    /**
     * this method from navigaiton presenter tells the view to show
     * the param fragment
     * @param fragment
     */
    @Override
    public void addFragment(BaseFragment fragment) {
        view.setFragment(fragment);
    }
}
