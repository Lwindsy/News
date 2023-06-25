package com.example.news.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.news.data.item.CommentItem
import com.example.news.ui.theme.ShowCommentsCard
import com.example.news.ui.utils.HomepageBottomBar
import org.w3c.dom.Comment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(
    commentList: List<CommentItem>,
    modifier: Modifier = Modifier
){
    Scaffold(

    ) {
        LazyColumn(contentPadding = it) {
            items(commentList) {
                ShowCommentsCard(comment = it)
            }
        }
    }
}