package com.example.news.data.item

import kotlinx.serialization.Serializable

const val FALSE = 0
const val TRUE = 1

@Serializable
data class ServerResult (
    val result:Int = FALSE
)