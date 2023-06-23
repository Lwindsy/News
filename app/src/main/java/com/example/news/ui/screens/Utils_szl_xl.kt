package com.example.news.ui.screens

import androidx.cardview.widget.CardView
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.news.data.BottomArticleTableUiState
import com.example.news.ui.viewmodel.NewsAppViewModel

/*
    TODO -> 王松 马小乐
     请注意，我为以下几个state{
        articleUiState -> 文章主体（显示整篇文章的ArticleScreen），
        searchTableUiState -> 搜索结果(SearchScreen)，
        headArticleTableUiState -> 首页（HomePageScreen）的头条列表，
        bottomArticleTableUiState -> 首页（HomePageScreen）底下的文章卡片列表信息，
        bookMarkedTableUiState -> 个人页面（ProfileScreen）收藏那里的列表
     }（都可以从NewsAppViewModel直接取用）
     定义了三种状态：loading,Success,Error。Error暂且忽略。
     我需要你们：
        将以上State对应的组件，全部做到loading状态和Success状态时分别调用不同的组件。
        Success自然就是正常的、加载成功的、你们已经写了的样子。
        而Loading应该是动态的呼吸效果，要做到这个，我给你们写了下面的例子HeadArticleCard_Loading
        请按照我给的例子，写好我们的卡片组件对应的Loading的样子
     如何区分Success和Loading？
        请看下面的第二个例子xxxScreen。值得注意的是，需要区分Loading的Screen都应按我给的范式来写
 */

// 加载中的卡片应该有的样子
@Composable
fun HeadArticleCard_Loading(
    modifier: Modifier = Modifier
){
    val infiniteTransition = rememberInfiniteTransition()
    // 这个 alpha 也是一种State，现在alpha会按照设置好的数值来回变动
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            // 来回变
            repeatMode = RepeatMode.Reverse
        )
    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 82.dp, max = 84.dp)
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
                    .size(80.dp)
                    .clip(CardDefaults.shape)
                    //此处copy函数为重点！！它会让这个组件的颜色随着alpha的不断变化而变化，从而达到“呼吸一样的效果”
                    .background(Color.Gray.copy(alpha = alpha))
            )
            Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
                Box(
                    modifier = modifier
                        .padding(start = 4.dp, top = 5.dp, bottom = 5.dp)
                        .height(25.dp)
                        .width(50.dp)
                        .background(Color.Gray.copy(alpha = alpha))
                )
                Row(modifier = modifier.padding(top = 5.dp, bottom = 7.dp)) {
                    Box(
                        modifier = modifier
                            .padding(start = 4.dp, end = 4.dp)
                            .height(15.dp)
                            .width(30.dp)
                            .background(Color.Gray.copy(alpha = alpha))
                    )
                    Box(
                        modifier = modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .height(15.dp)
                            .width(30.dp)
                            .background(Color.Gray.copy(alpha = alpha))
                    )
                }
            }
        }
    }
}

@Composable
fun xxxScreen(
    viewModel: NewsAppViewModel,
    modifier: Modifier = Modifier
) {
    /* 别的不管咋样都正常显示的组件 比如*/

    when (viewModel.bottomArticleTableUiState) {
        is BottomArticleTableUiState.Loading -> {
            /* 你写好的Loading组件，比如你写一个HeadArticleTable，里面是一个LazyRow展现上面的HeadArticleCard_Loading */
        }
        is BottomArticleTableUiState.Success -> {
            /* 你写好的Success组件 */
        }
        is BottomArticleTableUiState.Error -> {
            /* 忽略 */
        }
    }

    Card(
        elevation = CardDefaults.cardElevation()
    ){

    }
    /* 别的不管咋样都正常显示的组件 */
}