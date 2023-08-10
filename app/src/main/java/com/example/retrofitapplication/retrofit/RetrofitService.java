package com.example.retrofitapplication.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/account/api/verify-id")
    Call<String> getEmailVerify(@Query("userId") String id);
}
