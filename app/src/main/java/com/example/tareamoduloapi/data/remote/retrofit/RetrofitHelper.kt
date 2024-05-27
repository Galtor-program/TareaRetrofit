package com.example.tareamoduloapi.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/typicode/demo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}