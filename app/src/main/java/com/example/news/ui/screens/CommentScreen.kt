package com.example.news.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.news.data.item.CommentItem
import com.example.news.ui.theme.ShowCommentsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(
    commentList: List<CommentItem>,
    modifier: Modifier = Modifier
){
    Scaffold {
        LazyColumn(contentPadding = it) {
            items(commentList) {comment ->
                ShowCommentsCard(comment = comment)
            }
        }
    }
}