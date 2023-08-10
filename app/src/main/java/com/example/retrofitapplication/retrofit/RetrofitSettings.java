package com.example.retrofitapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSettings {
    public Retrofit init(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.0.11:8085")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
