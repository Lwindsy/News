package com.example.news.data.item

import kotlinx.serialization.Serializable
import java.util.Calendar
import java.util.Date

@Serializable
data class CommentItem(
    val userId : String = "",
    val commentText : String = "",
    val releaseTime : String = "",
    val articleId:String = ""
)