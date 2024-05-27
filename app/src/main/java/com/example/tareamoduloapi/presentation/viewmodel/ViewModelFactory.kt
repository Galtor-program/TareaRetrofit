package com.example.tareamoduloapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tareamoduloapi.domain.PostUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory (private val postUseCase: PostUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(postUseCase)as T
        }
        throw  IllegalArgumentException("Unknown ViewModel ")
    }
}