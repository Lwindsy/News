package com.example.news.data.item

import kotlinx.serialization.Serializable

@Serializable
data class CommentItem(
    val userId : String = "",
    val userName : String = "",
    val commentText : String = "",
    val releaseTime : String = "",
    val articleId:String = ""
)