package com.example.news.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.news.data.ArticleTableUiState
import com.example.news.data.ArticleUiState
import com.example.news.data.LogInInfoUiState
import com.example.news.data.SignUpInfoUiState
import com.example.news.data.UserUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/* TODO :
    ①定义好各个更新State的函数，如updateArticle用于查询数据并更新ArticleUiState
    ②定义好利用Url在局域网内查询主机数据库的各个函数 -> 孙振林's Job
 */

class NewsAppViewModel : ViewModel() {
    // 五个uiState
    private val _articleUiState = MutableStateFlow(ArticleUiState())
    val articleUiState: StateFlow<ArticleUiState> = _articleUiState.asStateFlow()

    private val _articleTableUiState = MutableStateFlow(ArticleTableUiState())
    val articleTableUiState: StateFlow<ArticleTableUiState> = _articleTableUiState.asStateFlow()

    private val _userUiState = MutableStateFlow(UserUiState())
    val userUiState: StateFlow<UserUiState> = _userUiState.asStateFlow()

    private val _logInInfoUiState = MutableStateFlow(LogInInfoUiState())
    val logInInfoUiState: StateFlow<LogInInfoUiState> = _logInInfoUiState.asStateFlow()

    private val _signUpInfoUiState = MutableStateFlow(SignUpInfoUiState())
    val signUpInfoUiState: StateFlow<SignUpInfoUiState> = _signUpInfoUiState.asStateFlow()

    /* TODO :
    *    ！！！注意，screen需要往这些函数传什么参数请自行添加（不过应该不会有）
    *    这些函数都需要数据查询。我接下来会写好springboot的数据库以url的形式调用，你们先假设已经下面这几个函数已经写好了，直接调用。
    *    ①注册提交函数
    *    ②登录提交函数
    *    ③进入文章函数（利用ID查询）
    *    ④用户查询函数
    *    ⑤时间转换（秒转换为分钟小时等）   */

    // 用于提交注册信息
    fun commitSignUpInfo(

    ) {

    }

    // 用于提交用户登录信息
    fun cmpUserInfo(

    ) {

    }

    // 获取文章信息（并更新State）
    fun getArticle(

    ) {

    }

    // 获取用户信息（并更新UserUiState）
    fun getUserInfo(

    ) {

    }

    // 查询文章列表,此处是给首页用的（需要根据不同的类型来查询新闻）
    fun getHomeArticleTable(

    ) {

    }

    // 时间转换
    private fun transSecond(

    ) {

    }


}

