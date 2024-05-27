package com.example.tareamoduloapi.domain

import com.example.tareamoduloapi.data.repository.PostApiRepositoryImpl
import com.example.tareamoduloapi.data.response.PostApiResponse

class PostUseCase(private val repositoryImpl: PostApiRepositoryImpl) {
    suspend fun getAllPosted() : MutableList<PostApiResponse>{
        return repositoryImpl.fetchAllPost()
    }
}