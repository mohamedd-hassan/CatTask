package com.mohamed.cattask

import android.app.Application
import com.mohamed.cattask.data.AppContainer
import com.mohamed.cattask.data.DefaultAppContainer

class PostsApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}