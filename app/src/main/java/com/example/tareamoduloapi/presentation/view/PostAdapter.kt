package com.example.tareamoduloapi.presentation.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tareamoduloapi.data.response.PostApiResponse
import com.example.tareamoduloapi.databinding.PostItemBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var posts = mutableListOf<PostApiResponse>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            this.notifyDataSetChanged()

        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val posted = posts[position]
        holder.bindPost(posted)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class  ViewHolder(private var binding: PostItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindPost(posted: PostApiResponse){
            binding.postTxt.text = posted.title
            binding.idtext.text = posted.id.toString()
        }
    }

}