package com.example.fatimazza.thingapp.network;

import com.example.fatimazza.thingapp.model.ProductDAO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProductAPIServices {

    @GET("products")
    Call<List<ProductDAO>> fetchProducts();

    @POST("products?")
    Call<ProductDAO> addProduct(
            @Query("product[name]") String name,
            @Query("product[price]") long price,
            @Query("product[description]") String desc);

}
