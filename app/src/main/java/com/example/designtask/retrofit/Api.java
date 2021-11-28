package com.example.designtask.retrofit;


import com.example.designtask.model.ProductInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://fakestoreapi.com/";
    @GET("products")
    Call<List<ProductInfo>> getProducts();
}