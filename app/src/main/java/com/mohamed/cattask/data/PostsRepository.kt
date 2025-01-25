package com.mohamed.cattask.data

import com.mohamed.cattask.model.Post
import com.mohamed.cattask.network.PostsApiService

class PostsRepository (
    private val postsApiService: PostsApiService
){
    suspend fun getPosts(): List<Post> {
        return postsApiService.getPosts()
    }
}