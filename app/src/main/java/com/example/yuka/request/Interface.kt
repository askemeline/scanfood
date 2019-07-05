package com.example.yuka.request

import com.example.yuka.request.ServerResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("getProduct")
    fun getProduct(@Query("barcode") barcode: String): Call<ServerResponse>
}