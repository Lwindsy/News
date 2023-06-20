package com.example.news.data

/* 貌似没什么必要 */
class ArticleItem(
    title: String,
    // the origin time would be in seconds
    releaseTime: Int,
    tag: String,
    author: String,
    commentList: List<String>,
    likeNumber: Int
) {
    init {
        require(releaseTime > 0) { " releaseTime:$releaseTime; must be > 0 " }
    }


}