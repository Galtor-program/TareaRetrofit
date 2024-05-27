package com.example.tareamoduloapi.data.remote.api

import com.example.tareamoduloapi.data.remote.retrofit.RetrofitHelper
import com.example.tareamoduloapi.data.response.PostApiResponse

class PostApiClient {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun  getAllPost(): MutableList<PostApiResponse>{
        val response = retrofit.create(PostApiService::class.java).getAllPost()
        return response
    }
}