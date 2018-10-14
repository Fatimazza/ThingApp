package com.example.fatimazza.thingapp.manage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseActivity;
import com.example.fatimazza.thingapp.network.RetrofitHelper;

import butterknife.BindView;

public class ManageActivity extends BaseActivity implements ManageContract.View {

    @BindView(R.id.et_name)
    public EditText etProductName;

    @BindView(R.id.et_price)
    public EditText etProductPrice;

    @BindView(R.id.et_desc)
    public EditText etProductDesc;

    private ManagePresenter managePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPresenter();
        bindViewToPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_manage;
    }

    @Override
    public void initPresenter() {
        managePresenter = new ManagePresenter(RetrofitHelper.getInstance().getProductAPIServices());
    }

    @Override
    public void bindViewToPresenter() {
        managePresenter.setMvpView(this);
    }

    @Override
    public void showErrorLog(Throwable throwable) {
        Log.d("retroFailure ", throwable.getMessage());
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Data FAILED to add.", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, "Data successfully added.", Toast.LENGTH_LONG).show();
        finish();
    }

    public void addThing (View view) {
        String productName = etProductName.getEditableText().toString();
        String productPrice = etProductPrice.getEditableText().toString();
        String productDesc = etProductDesc.getText().toString();
        long price = TextUtils.isEmpty(productPrice) ? 0 : Long.valueOf(productPrice);

        if (TextUtils.isEmpty(productName)
                || TextUtils.isEmpty(productPrice)
                || TextUtils.isEmpty(productDesc)) {
            Toast.makeText(this, "Please fill in all data", Toast.LENGTH_LONG).show();
        } else {
            managePresenter.addProduct(productName, price, productDesc);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        managePresenter.setMvpView(null);
    }
}
