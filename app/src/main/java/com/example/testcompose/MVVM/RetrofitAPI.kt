package com.example.testcompose.MVVM

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface RetrofitAPI {

    @POST("/buyers/create")
    fun postBuyer(@Body dataModel: RegisterUserItem?): Call<RegisterUserItem?>?

    @DELETE("/buyers/{id}")
     fun deleteBuyer(): Response<RegisterUserItem>
}