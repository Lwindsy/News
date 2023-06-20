package com.example.news.data

data class ArticleTableUiState(

    /* these Lists would surely be initialized in following code as users operate.*/

    val searchTable: List<ArticleItem>? = null,
    val homeTopTable: List<ArticleItem>? = null,
    val homeBottomTable: List<ArticleItem>? = null,
    val bookMarkedTable: List<ArticleItem>? = null
)