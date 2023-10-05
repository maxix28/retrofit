package com.example.retrofit.utils

import com.example.retrofit.ApiInterface
import com.example.retrofit.ApiInterfaceUsers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api : ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(utils.Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    val apiUsers : ApiInterfaceUsers by lazy {
        Retrofit.Builder()
            .baseUrl(utils.Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterfaceUsers::class.java)
    }
}