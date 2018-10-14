package com.example.fatimazza.thingapp.manage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;

import butterknife.BindView;

public class ManageActivity extends BaseActivity implements ManageContract.View {

    @BindView(R.id.et_name)
    public EditText etProductName;

    @BindView(R.id.et_price)
    public EditText etProductPrice;

    @BindView(R.id.et_desc)
    public EditText etProductDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_manage;
    }

    public void addThing (View view) {
        if (TextUtils.isEmpty(etProductName.getText().toString())
                || TextUtils.isEmpty(etProductPrice.getText().toString())
                || TextUtils.isEmpty(etProductDesc.getText().toString())) {
            Toast.makeText(this, "Please fill in all data", Toast.LENGTH_LONG).show();
        } else {

        }
    }
}
