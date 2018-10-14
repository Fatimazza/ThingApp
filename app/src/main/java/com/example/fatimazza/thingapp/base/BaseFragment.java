package com.example.fatimazza.thingapp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fatimazza.thingapp.R;

/**
 * the base fragment implements
 * the fragment contract view for navigation
 * to set the default methods implementation
 */
public class BaseFragment extends Fragment implements FragmentContract.View {

    protected View rootView;

    /**
     * navigation presenter instance
     * declared in base for easier access
     */
    protected FragmentContract.Presenter fragmentContractPresenter;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_main, container, false);
        return rootView;
    }

    /**
     * set the navigation presenter instance
     * @param presenter
     */
    @Override
    public void attachPresenter(FragmentContract.Presenter presenter) {
        fragmentContractPresenter = presenter;
    }
}
