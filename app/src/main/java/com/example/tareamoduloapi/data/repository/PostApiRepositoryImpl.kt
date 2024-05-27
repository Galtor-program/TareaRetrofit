package com.example.tareamoduloapi.data.repository

import com.example.tareamoduloapi.data.remote.api.PostApiService
import com.example.tareamoduloapi.data.response.PostApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostApiRepositoryImpl(private var apiService: PostApiService): PostApiRepository {
    override suspend fun fetchAllPost(): MutableList<PostApiResponse> {
        return withContext(Dispatchers.IO){
            val listaPost = apiService.getAllPost()
            listaPost
        }
    }

}