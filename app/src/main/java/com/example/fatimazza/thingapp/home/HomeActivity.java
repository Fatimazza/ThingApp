package com.example.fatimazza.thingapp.home;

import android.os.Bundle;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }
}
