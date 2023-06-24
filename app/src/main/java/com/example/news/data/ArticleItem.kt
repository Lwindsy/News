package com.example.news.data


class ArticleItem(
    title: String = "",
    // the origin time would be in seconds
    releaseTime: Int = -1,
    tag: String = "",
    author: String = "",
    commentList: List<CommentItem> = List<CommentItem>(0){CommentItem()},
    likeNumber: Int = -1
) {
    init {
        require(releaseTime > 0) { " releaseTime:$releaseTime; must be > 0 " }
    }
}

