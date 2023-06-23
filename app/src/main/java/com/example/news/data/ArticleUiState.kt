package com.example.news.data

sealed interface ArticleUiState {
    data class Success(
        // list of the article's comments' Id
        val commentList: List<String>? = null,
        // the total of likes
        val likeNumber: Int = 0,
        // body of the article
        val bodyText: String = "",
        // title
        val title: String = "",
        // author's Id
        val authorId: String = ""
    ) : SearchTableUiState
    object Loading : ArticleUiState
    object Error : ArticleUiState
}