package com.example.news.network

import com.example.news.data.item.ArticleItem
import com.example.news.data.item.CommentItem
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import com.example.news.data.item.UserItem
import com.example.news.data.item.ServerResult
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL =
    "http://10.0.2.2:8080"

// 请务必将手机和电脑连接同一局域网
//private const val PC_URL =
//    "http://{your computer's ip}:8080"


@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("/user/{id}")
    suspend fun getUserById(@Path("id") id: Long): UserItem

    @POST("/user/create")
    suspend fun getSignUpResult(@Body user: UserItem): ServerResult

    @GET("/article/{id}")
    suspend fun getArticleById(@Path("id") id: Long): ArticleItem

    @GET("/article/SBT/{type}")
    suspend fun getArticleByType(@Path("type") type: String): List<ArticleItem>

    @GET("/article/BSOType/{type}")
    suspend fun getArticleByBlurType(@Path("type") type: String): List<ArticleItem>

    @GET("/article/BSOText/{text}")
    suspend fun getArticleByBlurText(@Path("text") text: String): List<ArticleItem>

    @GET("/article/BSOTitle/{title}")
    suspend fun getArticleByBlurTitle(@Path("title") title: String): List<ArticleItem>

    @GET("/article/BSOAuthor/{author}")
    suspend fun getArticleByBlurAuthor(@Path("author") author: String): List<ArticleItem>

    @GET("/bookmark/{id}")
    suspend fun getBookmarkListById(@Path("id") id: Long): List<ArticleItem>

    @GET("/comment/article/{id}")
    suspend fun getCommentListByArticleId(@Path("id") id: Long): List<CommentItem>

    @GET("/comment/user/{id}")
    suspend fun getCommentListByUserId(@Path("id") id: Long): List<CommentItem>

    @GET("/follow/{id}")
    suspend fun getFollowingListById(@Path("id") id: Long): List<UserItem>

    @GET("/likes/GULN/{id}")
    suspend fun getUserLikeNum(@Path("id") id: Long): ServerResult

    @GET("/likes/GALN/{id}")
    suspend fun getArticleLikeNum(@Path("id") id: Long): ServerResult

    @POST("/user/login")
    suspend fun getLoginResult(@Body user: UserItem): ServerResult
}


object NewsApi {
    val retrofitService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}