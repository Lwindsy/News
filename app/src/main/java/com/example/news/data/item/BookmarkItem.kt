package com.example.news.data.item

import kotlinx.serialization.Serializable

@Serializable
data class BookmarkItem(
    val userId:String = "",
    val articleId:String = ""
)