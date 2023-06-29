package com.example.news.data.item

import kotlinx.serialization.Serializable

// all information you need about an article
@Serializable
data class ArticleItem (
    val title: String = "",
    val releaseTime: String = "",
    val bodyText: String = "",
    val type: String = "",
    val authorId: String = "",
    val articleId: String = "",
    val authorName: String = "",
)

