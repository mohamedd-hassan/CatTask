package com.mohamed.cattask.network

import com.mohamed.cattask.model.Post
import retrofit2.http.GET

interface PostsApiService{
    @GET("posts")
    suspend fun getPosts(): List<Post>
}