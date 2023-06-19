package com.example.news.data

data class ArticleUiState(
    // list of the article's comments' Id
    val commentList: List<String>,
    // the total of likes
    val likeNumber: Int,
    // body of the article
    val bodyText: String,
    // title
    val title:String,
    // author's Id
    val authorId:String
)
