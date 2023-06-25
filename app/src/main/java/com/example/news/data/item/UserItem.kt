package com.example.news.data.item

import kotlinx.serialization.Serializable

@Serializable
data class UserItem(
    val userId:String = "",
    val userName:String = "",
    val password:String = ""
)