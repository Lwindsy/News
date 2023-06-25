package com.example.news.data.item

import kotlinx.serialization.Serializable

@Serializable
data class FollowItem(
    val userId:String = "",
    val followingUserId:String = ""
)