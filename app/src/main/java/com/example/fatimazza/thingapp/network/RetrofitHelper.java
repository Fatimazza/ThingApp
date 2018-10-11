package com.example.fatimazza.thingapp.network;

import com.example.fatimazza.thingapp.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper retrofitHelper;

    private Retrofit mRetrofit;

    private RetrofitHelper() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.WEB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitHelper getInstance() {
        if (retrofitHelper == null) {
            retrofitHelper = new RetrofitHelper();
        }
        return retrofitHelper;
    }

}
