package com.example.news.data

import com.example.news.data.item.ArticleItem

sealed interface SearchTableUiState {
    data class Success(val searchTable: List<ArticleItem>) : SearchTableUiState
    object Loading : SearchTableUiState
    object Error : SearchTableUiState
}

sealed interface HeadArticleTableUiState {
    data class Success(val headArticleTable: List<ArticleItem>) : HeadArticleTableUiState
    object Loading : HeadArticleTableUiState
    object Error : HeadArticleTableUiState
}

sealed interface BottomArticleTableUiState {
    data class Success(val Table: List<ArticleItem>) : BottomArticleTableUiState
    object Loading : BottomArticleTableUiState
    object Error : BottomArticleTableUiState
}

sealed interface BookMarkedTableUiState {
    data class Success(val bookMarkedTable: List<ArticleItem>) : BookMarkedTableUiState
    object Loading : BookMarkedTableUiState
    object Error : BookMarkedTableUiState
}