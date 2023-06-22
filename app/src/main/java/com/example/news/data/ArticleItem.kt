package com.example.news.data

/* 貌似没什么必要 */
class ArticleItem(
    title: String = "",
    // the origin time would be in seconds
    releaseTime: Int = -1,
    tag: String = "",
    author: String = "",
    commentList: List<String>? = null,
    likeNumber: Int = -1
) {
    init {
        require(releaseTime > 0) { " releaseTime:$releaseTime; must be > 0 " }
    }


}

sealed interface ShopUiState {
    data class Success(val shopDetails: List<String>) : ShopUiState
    object Error : ShopUiState
    object Loading : ShopUiState
}