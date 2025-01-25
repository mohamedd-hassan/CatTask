package com.mohamed.cattask.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamed.cattask.model.Post

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    post: Post
){
    Card(
        modifier = modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column {
            Text(post.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(post.body)
        }
    }
}