package com.example.news.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.data.BottomArticleTableUiState
import com.example.news.data.HeadArticleTableUiState
import com.example.news.ui.theme.LongCard
import com.example.news.ui.theme.ShortCard
import com.example.news.ui.theme.Profile_loading_card
import com.example.news.ui.utils.HeadArticleCardLoading
import com.example.news.ui.viewmodel.NewsAppViewModel

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    onArticleCardClick: (String) -> Unit = {},
    onTypeClick:(String) -> Unit = {},
    viewModel: NewsAppViewModel = NewsAppViewModel()
) {

    val headArticleTableState = viewModel.headArticleTableUiState
    val bottomArticleTableState = viewModel.bottomArticleTableUiState

    Column {
        //世界新闻
        Text(
            text = "世界新闻",
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(16.dp))
        // classify different situations: Loading Success else(Error)
        LazyRow(content = {
            when (headArticleTableState) {
                is HeadArticleTableUiState.Success -> {
                    items(headArticleTableState.headArticleTable){
                        Spacer(modifier = Modifier.width(5.dp))
                        ShortCard(it,onArticleCardClick)
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
                is HeadArticleTableUiState.Loading -> {
                    items(3){
                        Spacer(modifier = Modifier.width(5.dp))
                        HeadArticleCardLoading()
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                else -> {

                }
            }
        })
        Spacer(modifier = Modifier.height(10.dp))
        //校园看点
        Text(
            text = "校园看点",
            color = Color.Black,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(16.dp))
        //分类框
        Box(modifier = Modifier
            .width(400.dp)
            .height(80.dp)
            .background(Color.White),){
            Row{
                Button(
                    onClick = { onTypeClick("notification") },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 8.dp,
                        bottomEnd = 8.dp
                    ) ,
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "通知")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { onTypeClick("onhit") },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "热门")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { onTypeClick("activity") },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "活动")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { onTypeClick("exam") },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart =8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "考试")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { onTypeClick("award") },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart =8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "表彰")
                }
            }
        }
        //向下滑动
        Box(
            modifier = Modifier
                .width(400.dp)
                .height(360.dp)
                .background(Color.White),
        ) {
            LazyColumn(
                content = {
                    // classify different situations: Loading Success else(Error)
                    when (bottomArticleTableState) {
                        is BottomArticleTableUiState.Success -> {
                            items(bottomArticleTableState.Table){
                                Spacer(modifier = Modifier.width(5.dp))
                                LongCard(it,onArticleCardClick)
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }
                        is BottomArticleTableUiState.Loading -> {
                            items(10){
                                Spacer(modifier = Modifier.width(5.dp))
                                Profile_loading_card()
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }

                        else -> {

                        }
                    }
                })
        }
    }
}