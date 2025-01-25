package com.mohamed.cattask.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.mohamed.cattask.model.Post

@Composable
fun PostsScreen(
    modifier: Modifier = Modifier,
    viewModel: PostsViewModel
){
    val posts = viewModel.postState.collectAsState().value.result

    PostsScreenContent(
        posts = posts)
}

@Composable
fun PostsScreenContent(

    posts: List<Post>
){
    LazyColumn {
        items(items =  posts, key = {it.id}){ post ->
            PostCard(
                post = post)
        }
    }
}