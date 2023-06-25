package com.example.news.data

import com.example.news.data.item.ArticleItem
import com.example.news.data.item.CommentItem

data class ArticleUiState(

    val articleItem: ArticleItem = ArticleItem(),

    val commentList: List<CommentItem> = listOf(),

    val likeNumber: Long = -1
)