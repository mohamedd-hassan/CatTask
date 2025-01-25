package com.mohamed.cattask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mohamed.cattask.PostsApplication
import com.mohamed.cattask.data.PostsRepository
import com.mohamed.cattask.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PostsState(
    val result: List<Post> = emptyList()
)

class PostsViewModel(
    private val postsRepository: PostsRepository
): ViewModel() {

    private val _postState = MutableStateFlow(PostsState())
    var postState = _postState.asStateFlow()


    init {
        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch {

           _postState.update {
               it.copy(
                   result = postsRepository.getPosts()
               )
           }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PostsApplication)
                val postsRepository = application.container.postsRepository
                PostsViewModel(postsRepository)
            }
        }
    }
}