package com.example.tareamoduloapi.data.repository

import com.example.tareamoduloapi.data.response.PostApiResponse

interface PostApiRepository {
    suspend fun fetchAllPost() : MutableList<PostApiResponse>
}