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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.data.BottomArticleTableUiState
import com.example.news.data.HeadArticleTableUiState
import com.example.news.ui.theme.LongCard
import com.example.news.ui.theme.NewsTheme
import com.example.news.ui.theme.ShortCard
import com.example.news.ui.theme.profile_loading_card
import com.example.news.ui.utils.HeadArticleCardLoading
import com.example.news.ui.viewmodel.NewsAppViewModel

/*
*   ①不用管search窗口，那是NewsBar的活儿
*   ②注意“世界新闻"需要是一个LazyRow可组合项（可横向滚动）
*   ③底下的新闻列表/新闻分类也需要是LazyColumn/LazyRow可组合项
*   ④两个新闻列表各写一个Card用于显示文章信息
*   ⑤会有一个函数返回一个Article对象用于给Card提供信息，直接调用即可
* */

/* TODO */

// 注意！你不应该在Screen部分更改State
@Composable
fun HomePageScreen(
    //OnClickExp: () -> Unit,
    modifier: Modifier = Modifier,
    onArticleCardClick: (String) -> Unit = {},
    onTypeClick:(String) -> Unit = {},
    viewModel: NewsAppViewModel = NewsAppViewModel()
) {

    var inputValue by remember { mutableStateOf("") }
    val input = inputValue ?: ""
    //img = artilce_img 这个地方应该是个img集合到时根据ID显示图片

    val painter = painterResource(id = R.drawable.z)
    val painter1 = painterResource(id = R.drawable.head_icon)

    /*//图片的描述 也可忽视这个
    val des = "this is android test"
    //title = article_title 也应该是个集合，依次显示
    val title = "This is Title of image"*/



    //滑动和下拉只显示六个
    val headArticleTableState = viewModel.headArticleTableUiState
    val bottomArticleTableState = viewModel.bottomArticleTableUiState
    //后面的大标题、小标题、事件都是要调用数据库显示

    Column {
        //世界新闻
        Text(
            text = "世界新闻",
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(16.dp))
        //向右滑动
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
            Row() {
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
                    /* TODO -> 马小乐 王松
                        马小乐：请你将这下面这个Box抽象成一个Card组件放到外面。因为这个组件还需要提供给Profile和Search两个页面用于显示信息
                            这代表着Loading状态下的卡片你也要抽象成一个Card_Loading组件。
                            记得，card是要可以点击进入文章的，请你使用Modifier.clickable属性
                        王松：当她抽象完之后，你直接在profile调用并展现即可
                    */
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
                                profile_loading_card()
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


@Preview
@Composable
fun prev1() {
    NewsTheme {
        HomePageScreen()
    }
}