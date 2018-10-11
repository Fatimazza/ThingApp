package com.example.fatimazza.thingapp.base;

public class BasePresenter<T extends BaseContractView> {

    private T mvpView;

    public BasePresenter() {

    }

    public T getMvpView() {
        return mvpView;
    }

    public void setMvpView(T mvpView) {
        this.mvpView = mvpView;
    }
}
