package com.example.fatimazza.thingapp.productadd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;

import com.example.fatimazza.thingapp.R;
import com.example.fatimazza.thingapp.base.BaseFragment;
import com.example.fatimazza.thingapp.productlist.ProductsFragment;

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
                fragmentContractPresenter.addFragment(new ProductsFragment());
                break;
        }
    }
}
