package com.example.fatimazza.thingapp.productadd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseFragment;
import com.example.fatimazza.thingapp.network.RetrofitHelper;

import butterknife.BindView;

public class AddProductFragment extends BaseFragment implements AddProductFragmentContract.View {

    @BindView(R.id.et_name)
    public EditText etProductName;

    @BindView(R.id.et_price)
    public EditText etProductPrice;

    @BindView(R.id.et_desc)
    public EditText etProductDesc;

    @BindView(R.id.fab_add_product)
    public FloatingActionButton fabAddProduct;

    AddProductPresenter addProductPresenter;

    public AddProductFragment() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_add_product;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabAddProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_add_product:

                String productName = etProductName.getEditableText().toString();
                String productPrice = etProductPrice.getEditableText().toString();
                String productDesc = etProductDesc.getText().toString();
                long price = TextUtils.isEmpty(productPrice) ? 0 : Long.valueOf(productPrice);

                if (TextUtils.isEmpty(productName)
                        || TextUtils.isEmpty(productPrice)
                        || TextUtils.isEmpty(productDesc)) {
                    Toast.makeText(getActivity(), "Please fill in all data", Toast.LENGTH_LONG).show();
                } else {
                    addProductPresenter.addProduct(productName, price, productDesc);
                }
                break;
        }
    }

    @Override
    public void initPresenter() {
        addProductPresenter = new AddProductPresenter(RetrofitHelper.getInstance().getProductAPIServices());
    }

    @Override
    public void bindViewToPresenter() {
        addProductPresenter.setMvpView(this);
    }

    @Override
    public void showErrorLog(Throwable throwable) {
        Log.d("retroFailure ", throwable.getMessage());
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getActivity(), "Data FAILED to add.", Toast.LENGTH_LONG).show();
//        finish();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(getActivity(), "Data successfully added.", Toast.LENGTH_LONG).show();
//        finish();
    }
}
