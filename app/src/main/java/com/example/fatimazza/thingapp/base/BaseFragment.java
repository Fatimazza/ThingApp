package com.example.fatimazza.thingapp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fatimazza.thingapp.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * the base fragment implements
 * the fragment contract view for navigation
 * to set the default methods implementation
 */
public abstract class BaseFragment extends Fragment implements FragmentContract.View {

    private Unbinder unbinder;

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

        rootView = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
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

    public abstract int getLayout();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
