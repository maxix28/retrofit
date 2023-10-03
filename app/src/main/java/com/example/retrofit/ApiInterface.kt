package com.example.retrofit

import com.example.retrofit.models.user
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
@GET("/posts/1")
    suspend fun getUser():Response<user>
}