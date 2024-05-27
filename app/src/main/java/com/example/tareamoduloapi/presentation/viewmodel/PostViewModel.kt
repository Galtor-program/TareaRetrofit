package com.example.tareamoduloapi.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tareamoduloapi.data.response.PostApiResponse
import com.example.tareamoduloapi.domain.PostUseCase
import kotlinx.coroutines.launch

class PostViewModel(private val useCase: PostUseCase): ViewModel() {
    private var allpostList = MutableLiveData<MutableList<PostApiResponse>>()
    val allPostListView
        get() = allpostList

    init {
        viewModelScope.launch {
            allpostList.value = useCase.getAllPosted()
        }
    }
}