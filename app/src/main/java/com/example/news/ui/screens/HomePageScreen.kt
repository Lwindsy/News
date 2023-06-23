package com.example.news.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.news.data.ArticleItem
import com.example.news.data.HeadArticleTableUiState
import com.example.news.ui.viewmodel.NewsAppViewModel

/* TODO
*   ①不用管search窗口，那是NewsBar的活儿
*   ②注意“世界新闻"需要是一个LazyRow可组合项（可横向滚动）
*   ③底下的新闻列表/新闻分类也需要是LazyColumn/LazyRow可组合项
*   ④两个新闻列表各写一个Card用于显示文章信息
*   ⑤会有一个函数返回一个Article对象用于给Card提供信息，直接调用即可*/

// 注意！你不应该在Screen部分更改State
@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsAppViewModel
) {
    val headArticleTableUiState = viewModel.headArticleTableUiState

    Column {
        Text(
            text = "世界新闻",
            modifier = Modifier
        )
        when(headArticleTableUiState){
            is HeadArticleTableUiState.Loading -> HeadArticleTable_Loading(

            )

            is HeadArticleTableUiState.Success -> HeadArticleTable_Success(
                articleTable = headArticleTableUiState.headArticleTable,
                modifier = Modifier
            )

            is HeadArticleTableUiState.Error -> HeadArticleTable_Error(

            )
       }
    }
}

/* TODO 把各个状态下的组件写好 */
@Composable
fun HeadArticleTable_Success(
    modifier: Modifier = Modifier,
    articleTable:List<ArticleItem>
){
    LazyRow{
        items(items = articleTable){
            HeadArticleCard(
                modifier = Modifier,
                articleItem = it
            )
        }
    }
}

@Composable
fun HeadArticleTable_Loading(
    modifier: Modifier = Modifier
){

}

@Composable
fun HeadArticleTable_Error(
    modifier: Modifier = Modifier
){

}

@Composable
fun HeadArticleCard(
    modifier: Modifier = Modifier,
    articleItem: ArticleItem = ArticleItem()
) {
    Box(
        modifier = Modifier
            .padding(all = 16.dp)
            

    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = "https://img1.imgtp.com/2023/06/22/vlbWGqCS.jpg",
                contentDescription = null,
            )
        }
    }
}

@Composable
fun HeadArticleCard_Loading(
    modifier: Modifier = Modifier
){
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )
}