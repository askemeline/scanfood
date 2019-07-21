package com.example.yuka.request

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Request{
    companion object {

        private val api = Retrofit.Builder()
            .baseUrl("https://api.formation-android.fr/getProduct")
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()
            .create(API::class.java)
        
    }
    
    fun getProduct(barcode: String, callback: Callback<ServerResponse>) {
        api.getProduct(barcode).enqueue(callback
        )
    }
}