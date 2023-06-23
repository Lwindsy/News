package com.example.news.data

class CommentItem(
    userId : String = "",
    commentText : String = "",
    releaseTime : Int = -1
) {
    init {
        require(releaseTime > 0){" releaseTime:$releaseTime; must be > 0 "}
    }
}