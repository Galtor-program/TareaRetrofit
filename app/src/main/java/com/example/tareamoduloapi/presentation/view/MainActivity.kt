package com.example.tareamoduloapi.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.tareamoduloapi.data.remote.api.PostApiService
import com.example.tareamoduloapi.data.remote.retrofit.RetrofitHelper
import com.example.tareamoduloapi.data.repository.PostApiRepositoryImpl
import com.example.tareamoduloapi.databinding.ActivityMainBinding
import com.example.tareamoduloapi.domain.PostUseCase
import com.example.tareamoduloapi.presentation.viewmodel.PostViewModel
import com.example.tareamoduloapi.presentation.viewmodel.ViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    private lateinit var adapterPost:PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = RetrofitHelper.getRetrofit().create(PostApiService::class.java)
        val repository = PostApiRepositoryImpl(apiService)
        val useCase = PostUseCase(repository)
        val viewModelFactory = ViewModelFactory(useCase)

        viewModel = ViewModelProvider(this,viewModelFactory )[PostViewModel::class.java]
        adapterPost = PostAdapter()

        binding.recycleItems.adapter = adapterPost
        binding.recycleItems.layoutManager = LinearLayoutManager(this)
        observeViewModel()

    }

     private fun observeViewModel(){
        viewModel.allPostListView.observe(this){ posts ->
            posts?.let {
                adapterPost.posts = it
                Log.i("post","posteos: $it")

            }
        }
    }
}