package com.example.news.data

import com.example.news.data.item.ArticleItem
import com.example.news.data.item.CommentItem
import com.example.news.data.item.LikeItem
import com.example.news.data.item.UserItem

data class UserUiState(
    /* 3 cases:{
    *   0L -> fail to log in
    *   1L -> successfully log in
    *   2L -> haven't try to log in yet*/
    /* TODO try to reset the logInState to 2L while the input field's content changes*/
    val success: Long = 2L,
    // 失败信息
    val failmsg: String = "",

    val userId: String = "",
    val userName: String = "",
    // list of following users' Id
    val followingList: List<UserItem> = listOf(),
    // list of the user's comments' Id
    val commentList: List<CommentItem> = listOf(),
    // list of the user's liked articles' Id
    val likeList: List<LikeItem> = listOf(),
    // list of the user's bookmarked articles' Id
    val bookmarkList: List<ArticleItem> = listOf(),

    // likeNum
    val likeNum: String = "-1",
    val commentNum: String = "-1",
    val followNum: String = "-1"
)