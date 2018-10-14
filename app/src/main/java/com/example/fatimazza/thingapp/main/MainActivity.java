package com.example.fatimazza.thingapp.main;

import android.os.Bundle;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;
import com.example.fatimazza.thingapp.base.BaseFragment;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }


    /**
     * sets a new fragment on fragment_container frame
     * layout and attaches to it the presenter
     * @param fragment
     */
    @Override
    public void setFragment(BaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
