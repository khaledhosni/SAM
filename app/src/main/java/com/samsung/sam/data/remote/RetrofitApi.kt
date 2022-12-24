package com.samsung.sam.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {

    var retrofit= Retrofit.Builder()
        .baseUrl("https://618ebc2e50e24d0017ce141f.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient().newBuilder().addInterceptor(HeaderInterceptor()).build())
        .build()

    val userService = retrofit.create(UserService::class.java)

}