package com.example.news.data

data class ArticleTableUiState(
    val searchTable: List<ArticleItem>,
    val homeTopTable: List<ArticleItem>,
    val homeBottomTable: List<ArticleItem>,
    val bookMarkedTable: List<ArticleItem>
)