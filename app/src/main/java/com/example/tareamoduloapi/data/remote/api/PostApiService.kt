package com.example.tareamoduloapi.data.remote.api

import com.example.tareamoduloapi.data.response.PostApiResponse
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getAllPost() : MutableList<PostApiResponse>
}
