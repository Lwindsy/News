package com.example.news.data.item

import kotlinx.serialization.Serializable

@Serializable
data class ArticleItem (
    val title: String = "",
    // the origin time would be in seconds
    val releaseTime: String = "",
    val bodyText: String = "",
    val type: String = "",
    val authorId: String = "",
    val articleId: String = "",
    val authorName: String = "",
)

