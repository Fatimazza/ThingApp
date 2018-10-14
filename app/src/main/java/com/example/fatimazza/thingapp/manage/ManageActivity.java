package com.example.fatimazza.thingapp.manage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;

public class ManageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_manage;
    }
}
