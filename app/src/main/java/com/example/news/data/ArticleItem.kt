package com.example.news.data

class ArticleItem(
    title:String,
    // the origin time would be in seconds
    releaseTime:Int,
    tag:String,
    author:String
){
    init {
        require(releaseTime > 0){" releaseTime:$releaseTime; must be > 0 "}
    }


}