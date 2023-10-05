package com.example.retrofit

import com.example.retrofit.models.user
import retrofit2.Response
import retrofit2.http.*

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




    @PUT("/posts/{id}")
    suspend fun putPost(
        @Path("id") id:Int,
        @Body user:user
    ):Response<user>
    @PATCH("/posts/{id}")
    suspend fun patchPost(
        @Path("id") id:Int,
        @Body user:user
    ):Response<user>



    @DELETE("/posts/{id}")
    suspend fun deletePost(
        @Path("id") id:Int
    ):Response<user>
}