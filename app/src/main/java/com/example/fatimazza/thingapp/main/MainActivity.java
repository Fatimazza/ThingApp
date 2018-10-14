package com.example.fatimazza.thingapp.main;

import android.os.Bundle;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;
import com.example.fatimazza.thingapp.base.BaseFragment;
import com.example.fatimazza.thingapp.productlist.ProductsFragment;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPresenter();
        setFragment(new ProductsFragment());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initPresenter() {
        mainPresenter = new MainPresenter(this);
    }

    /**
     * sets a new fragment on fragment_container frame
     * layout and attaches to it the presenter
     * @param fragment
     */
    @Override
    public void setFragment(BaseFragment fragment) {

        //ataching to fragment the navigation presenter
        fragment.attachPresenter(mainPresenter);

        //showing the fragment on screen
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
