package com.example.retrofit

import com.example.retrofit.models.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceUsers {
    @GET("/posts")
    suspend fun getAllUser(): Response<Users>

}