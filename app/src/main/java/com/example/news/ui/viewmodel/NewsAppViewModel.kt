package com.example.news.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.news.data.ArticleItem
import com.example.news.data.ArticleUiState
import com.example.news.data.BookMarkedTableUiState
import com.example.news.data.BottomArticleTableUiState
import com.example.news.data.HeadArticleTableUiState
import com.example.news.data.LogInInfoUiState
import com.example.news.data.SearchTableUiState
import com.example.news.data.SignUpInfoUiState
import com.example.news.data.UserUiState
import com.example.news.ui.screens.ArticleScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.SocketTimeoutException

/* TODO :
    ①定义好各个更新State的函数，如updateArticle用于查询数据并更新ArticleUiState
    ②定义好利用Url在局域网内查询主机数据库的各个函数 -> 孙振林's Job
 */

const val HEAD_TABLE = 0
const val BOTTOM_TABLE = 1
const val BOOKMARKED_TABLE = 2
const val SEARCH_TABLE = 3

class NewsAppViewModel : ViewModel() {


    // 八个uiState
    // 默认为Loading状态
    var articleUiState : ArticleUiState by mutableStateOf(ArticleUiState.Loading)
        private set

    var searchTableUiState : SearchTableUiState by mutableStateOf(SearchTableUiState.Loading)
        private set

    var headArticleTableUiState : HeadArticleTableUiState by mutableStateOf(HeadArticleTableUiState.Loading)
        private set

    var bottomArticleTableUiState : BottomArticleTableUiState by mutableStateOf(BottomArticleTableUiState.Loading)
        private set

    var bookMarkedTableUiState : BookMarkedTableUiState by mutableStateOf(BookMarkedTableUiState.Loading)
        private set

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
        viewModelScope.launch {

        }
    }

    // 查询文章列表,此处是给首页用的（需要根据不同的类型来查询新闻）
    fun getHomeArticleTable(
        tableType: Int = HEAD_TABLE,
        start: Int = 0,
        num: Int,
        articleType: Int = -1
    ) {
        // 先行改变
        viewModelScope.launch{
            when (tableType) {
                HEAD_TABLE -> {
                    // on loading
                    headArticleTableUiState = HeadArticleTableUiState.Loading
                    delay(2000)
                    headArticleTableUiState = try {
                        HeadArticleTableUiState.Success(
                            headArticleTable = getArticleTable(
                                num = num,
                                tableType = tableType,
                                articleType = articleType,
                                start = start
                            )
                        )
                    }
                    catch (e: IOException) {
                        Log.e("IOException", e.toString())
                        HeadArticleTableUiState.Error
                    } catch (e: HttpException) {
                        Log.e("HttpException", e.toString())
                    HeadArticleTableUiState.Error
                    } catch (e: SocketTimeoutException) {
                        Log.e("SocketTimeoutException", e.toString())
                    HeadArticleTableUiState.Error
                    } catch (e: Exception) {
                        Log.e("Exception", e.toString())
                    HeadArticleTableUiState.Error
                    }
                }

                SEARCH_TABLE -> {
                    // on loading
                    searchTableUiState = SearchTableUiState.Loading
                    delay(2000)
                    searchTableUiState = try {
                        SearchTableUiState.Success(
                            searchTable = getArticleTable(
                                num = num,
                                tableType = tableType,
                                articleType = articleType,
                                start = start
                            )
                        )
                    }
                    catch (e: IOException) {
                        Log.e("IOException", e.toString())
                        SearchTableUiState.Error
                    } catch (e: HttpException) {
                        Log.e("HttpException", e.toString())
                        SearchTableUiState.Error
                    } catch (e: SocketTimeoutException) {
                        Log.e("SocketTimeoutException", e.toString())
                        SearchTableUiState.Error
                    } catch (e: Exception) {
                        Log.e("Exception", e.toString())
                        SearchTableUiState.Error
                    }
                }

                BOOKMARKED_TABLE -> {
                    // on loading
                    bookMarkedTableUiState = BookMarkedTableUiState.Loading
                    delay(2000)
                    bookMarkedTableUiState = try {
                        BookMarkedTableUiState.Success(
                            bookMarkedTable = getArticleTable(
                                num = num,
                                tableType = tableType,
                                articleType = articleType,
                                start = start
                            )
                        )
                    }
                    catch (e: IOException) {
                        Log.e("IOException", e.toString())
                        BookMarkedTableUiState.Error
                    } catch (e: HttpException) {
                        Log.e("HttpException", e.toString())
                        BookMarkedTableUiState.Error
                    } catch (e: SocketTimeoutException) {
                        Log.e("SocketTimeoutException", e.toString())
                        BookMarkedTableUiState.Error
                    } catch (e: Exception) {
                        Log.e("Exception", e.toString())
                        BookMarkedTableUiState.Error
                    }
                }

                BOTTOM_TABLE -> {
                    // on loading
                    bottomArticleTableUiState = BottomArticleTableUiState.Loading
                    delay(2000)
                    bottomArticleTableUiState = try {
                        BottomArticleTableUiState.Success(
                            bottomArticleTable = getArticleTable(
                                num = num,
                                tableType = tableType,
                                articleType = articleType,
                                start = start
                            )
                        )
                    }
                    catch (e: IOException) {
                        Log.e("IOException", e.toString())
                        BottomArticleTableUiState.Error
                    } catch (e: HttpException) {
                        Log.e("HttpException", e.toString())
                        BottomArticleTableUiState.Error
                    } catch (e: SocketTimeoutException) {
                        Log.e("SocketTimeoutException", e.toString())
                        BottomArticleTableUiState.Error
                    } catch (e: Exception) {
                        Log.e("Exception", e.toString())
                        BottomArticleTableUiState.Error
                    }
                }
            }
        }

    }

    // 时间转换
    private fun transSecond(

    ) {

    }

    private fun getArticleTable (
        tableType: Int,
        start :Int = 0,
        num: Int,
        articleType: Int = -1
    ) : List<ArticleItem>{
        /* TODO 根据url查询 */
        return List(1){
            _ -> ArticleItem()
        }
    }

}

