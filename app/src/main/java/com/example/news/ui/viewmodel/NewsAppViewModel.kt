package com.example.news.ui.viewmodel

import android.content.ContentValues
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.news.data.item.ArticleItem
import com.example.news.data.ArticleUiState
import com.example.news.data.BookMarkedTableUiState
import com.example.news.data.BottomArticleTableUiState
import com.example.news.data.HeadArticleTableUiState
import com.example.news.data.LogInInfoUiState
import com.example.news.data.SearchTableUiState
import com.example.news.data.SignUpInfoUiState
import com.example.news.data.UserUiState
import com.example.news.data.item.UserItem
import com.example.news.network.NewsApi
import com.example.news.network.NewsApiService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.SocketTimeoutException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

/* TODO :
    ①定义好各个更新State的函数，如updateArticle用于查询数据并更新ArticleUiState
    ②定义好利用Url在局域网内查询主机数据库的各个函数 -> 孙振林's Job
 */

const val HEAD_TABLE = 0
const val BOTTOM_TABLE = 1
const val BOOKMARKED_TABLE = 2
const val SEARCH_TABLE = 3

const val DELAY_TIME = 1300L

class NewsAppViewModel : ViewModel() {


    // 八个uiState
    // 默认为Loading状态

    var searchTableUiState: SearchTableUiState by mutableStateOf(SearchTableUiState.Loading)
        private set

    var headArticleTableUiState: HeadArticleTableUiState by mutableStateOf(HeadArticleTableUiState.Loading)
        private set

    var bottomArticleTableUiState: BottomArticleTableUiState by mutableStateOf(
        BottomArticleTableUiState.Loading
    )
        private set

    var bookMarkedTableUiState: BookMarkedTableUiState by mutableStateOf(BookMarkedTableUiState.Loading)
        private set

    private val _articleUiState = MutableStateFlow(ArticleUiState())
    val articleUiState: StateFlow<ArticleUiState> = _articleUiState.asStateFlow()

    private val _userUiState = MutableStateFlow(UserUiState())
    val userUiState: StateFlow<UserUiState> = _userUiState.asStateFlow()

    private val _logInInfoUiState = MutableStateFlow(LogInInfoUiState())
    val logInInfoUiState: StateFlow<LogInInfoUiState> = _logInInfoUiState.asStateFlow()

    private val _signUpInfoUiState = MutableStateFlow(SignUpInfoUiState())
    val signUpInfoUiState: StateFlow<SignUpInfoUiState> = _signUpInfoUiState.asStateFlow()

    /* TODO :
    *    ！！！注意，screen需要往这些函数传什么参数请自行添加（不过应该不会有）
    *    这些函数都需要数据查询。我接下来会写好springBoot的数据库以url的形式调用，你们先假设已经下面这几个函数已经写好了，直接调用。
    *    ①注册提交函数
    *    ②登录提交函数
    *    ③进入文章函数（利用ID查询）
    *    ④用户查询函数
    *    ⑤时间转换（秒转换为分钟小时等）   */

    // 用于提交注册信息
    fun commitSignUpInfo(
        userItem: UserItem
    ) {
        viewModelScope.launch{
            _signUpInfoUiState.update { currentState ->
                currentState.copy(
                    signUpResultUiState = NewsApi.retrofitService.getSignUpResult(userItem).result == 1
                )
            }
        }
    }

    // 用于提交用户登录信息
    fun cmpUserInfo(
        userItem: UserItem
    ) {
        viewModelScope.launch{
            _userUiState.update { currentState ->
                currentState.copy(
                    success = NewsApi.retrofitService.getLoginResult(userItem.userId.toLong(),userItem.password).result.toLong(),
                    userId = userItem.userId,
                    userName = userItem.userName
                )
            }
        }
    }

    // 获取文章信息（并更新State）
    fun getArticle(
        articleId : Long
    ) {
        viewModelScope.launch {
            coroutineScope {
                launch {
                    _articleUiState.update { currentState ->
                        currentState.copy(
                            articleItem = NewsApi.retrofitService.getArticleById(articleId),
                            likeNumber = NewsApi.retrofitService.getArticleLikeNum(articleId).result.toLong(),
                            commentList = NewsApi.retrofitService.getCommentListByArticleId(articleId)
                        )

                    }
                    Log.d(ContentValues.TAG, "zzz")
                }
            }
        }
    }

    // 获取用户信息（并更新UserUiState）
    fun getUserInfo(
        userId: Long,
    ) {
        viewModelScope.launch {
            coroutineScope {
                // id
                launch {
                    _userUiState.update { currentState ->
                        currentState.copy(
                            userId = NewsApi.retrofitService.getUserById(userId).userId
                        )
                    }
                }
                Log.d("z","id")
                // name
                launch {
                    _userUiState.update { currentState ->
                        currentState.copy(
                            userName = NewsApi.retrofitService.getUserById(userId).userName
                        )
                    }
                }
                Log.d("z","name")
                // bookmarkList
                launch {
                    _userUiState.update { currentState ->
                        currentState.copy(
                            bookmarkList = NewsApi.retrofitService.getBookmarkListById(userId)
                        )
                    }
                }
                Log.d("z","bookmarkList")
                // likeNum
                launch {
                    _userUiState.update { currentState ->
                        currentState.copy(
                            likeNum = NewsApi.retrofitService.getUserLikeNum(userId).result.toString()
                        )
                    }
                }
                Log.d("z","likeNum")
                // commentNum and List
                launch {
                    _userUiState.update { currentState ->
                        currentState.copy(
                            commentList = NewsApi.retrofitService.getCommentListByUserId(userId),
                            commentNum = NewsApi.retrofitService.getCommentListByUserId(userId).size.toString()
                        )
                    }
                }
                Log.d("z","commentNum")
                // followNum and List
                launch {
                    _userUiState.update { currentState ->
                        currentState.copy(
                            followingList = NewsApi.retrofitService.getFollowingListById(userId),
                            followNum = NewsApi.retrofitService.getFollowingListById(userId).size.toString()
                        )
                    }
                }
                Log.d("z","followNum")
            }
        }
    }

    // 查询文章列表
    fun getArticleTable(
        tableType: Int = HEAD_TABLE,
        articleType: String = "",
        userId : Long = -1,
        searchText : String = ""
    ) {
        viewModelScope.launch {
            when (tableType) {
                HEAD_TABLE -> {
                    // 先Loading
                    headArticleTableUiState = HeadArticleTableUiState.Loading
                    delay(DELAY_TIME)
                    headArticleTableUiState = HeadArticleTableUiState.Success(
                        NewsApi.retrofitService.getArticleByType(articleType)

                    )
                    Log.d(ContentValues.TAG,"111")
                }

                BOTTOM_TABLE -> {
                    bottomArticleTableUiState = BottomArticleTableUiState.Loading
                    delay(DELAY_TIME)
                    bottomArticleTableUiState = BottomArticleTableUiState.Success(
                        NewsApi.retrofitService.getArticleByType(articleType)
                    )
                    Log.d(ContentValues.TAG,"222")
                }

                BOOKMARKED_TABLE -> {
                    bookMarkedTableUiState = BookMarkedTableUiState.Loading
                    delay(DELAY_TIME)
                    bookMarkedTableUiState = BookMarkedTableUiState.Success(
                        NewsApi.retrofitService.getBookmarkListById(userId)
                    )
                    Log.d(ContentValues.TAG,"333")
                }

                SEARCH_TABLE -> {
                    searchTableUiState = SearchTableUiState.Loading
                    delay(DELAY_TIME)
                    searchTableUiState = SearchTableUiState.Success(
                        NewsApi.retrofitService.getArticleByBlurText(searchText) +
                                NewsApi.retrofitService.getArticleByBlurTitle(searchText) +
                                NewsApi.retrofitService.getArticleByBlurAuthor(searchText) +
                                NewsApi.retrofitService.getArticleByBlurType(searchText)
                    )
                }
            }
        }
    }

    fun setSuccessFalse(){
        viewModelScope.launch{
            _userUiState.update { currentState ->
                currentState.copy(
                    success = 0L
                )
            }
        }
    }
    // 时间转换
    @RequiresApi(Build.VERSION_CODES.O)
    fun trans(releaseTime: String):String{
        var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val current = releaseTime
        val startTime = LocalDateTime
            .parse(current, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        var sTime: Date = dateFormat.parse(startTime) as Date
        var eTime: Date = Calendar.getInstance().time//系统现在时间
        val diff = eTime.time - sTime.time
        val days = diff / (1000 * 60 * 60 * 24)
        val hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
        val minutes = ((diff - days * (1000 * 3600 * 24)) - hours * (1000 * 3600)) / (1000 * 60)
        val second = (diff - days * 1000 * 3600 * 24 - hours * 1000 * 3600 - minutes * 1000 * 60) / 1000
        if(days > 0)
            return "$days 天前"
        else if(hours > 0)
            return "$hours 小时前"
        else if(minutes > 0)
            return "$minutes 分钟前"
        else if(second > 0)
            return "$second 秒前"
        else
            return "刚刚"
    }

}




