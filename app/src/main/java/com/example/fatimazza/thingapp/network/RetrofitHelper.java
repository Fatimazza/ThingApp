package com.example.fatimazza.thingapp.network;

import com.example.fatimazza.thingapp.utils.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper retrofitHelper;

    private Retrofit mRetrofit;

    private ProductAPIServices productAPIServices;

    private RetrofitHelper() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.WEB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(setupLoggingInterceptor().build())
                .build();

        productAPIServices = mRetrofit.create(ProductAPIServices.class);
    }

    public ProductAPIServices getProductAPIServices() {
        return productAPIServices;
    }

    public static RetrofitHelper getInstance() {
        if (retrofitHelper == null) {
            retrofitHelper = new RetrofitHelper();
        }
        return retrofitHelper;
    }

    private OkHttpClient.Builder setupLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return httpClient;
    }

}
