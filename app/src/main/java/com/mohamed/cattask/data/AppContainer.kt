package com.mohamed.cattask.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mohamed.cattask.network.PostsApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val postsRepository: PostsRepository
}

class DefaultAppContainer: AppContainer{

    private val baseUrl = "https://jsonplaceholder.typicode.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()


    private val retrofitService: PostsApiService by lazy{
        retrofit.create(PostsApiService::class.java)
    }

    override val postsRepository: PostsRepository by lazy {
        PostsRepository(retrofitService)
    }
}
