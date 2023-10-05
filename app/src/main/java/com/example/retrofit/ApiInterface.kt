package com.example.retrofit

import com.example.retrofit.models.user
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
@GET("/posts/1")
    suspend fun getUser():Response<user>


    @POST("/posts")
    suspend fun createPost(
        @Body user:user
    ):Response<user>



    @FormUrlEncoded
    @POST("/posts")
    suspend fun createUrlPost(
        @Field("id")id:Int,
        @Field("body")body:String,
        @Field("title")title:String,


        ):Response<user>
}