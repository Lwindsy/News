package com.example.news.data.item

import kotlinx.serialization.Serializable

@Serializable
data class LikeItem(
    val userId:String = "",
    val articleId:String = ""
)