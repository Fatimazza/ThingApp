package com.example.fatimazza.thingapp.base;

public class BasePresenter<T extends BaseContractView> {

    private T mvpView;

    public BasePresenter(T mvpView) {
        this.mvpView = mvpView;
    }

    public T getMvpView() {
        return mvpView;
    }

    public void setMvpView(T mvpView) {
        this.mvpView = mvpView;
    }
}
