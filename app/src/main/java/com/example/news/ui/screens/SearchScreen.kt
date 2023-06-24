package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.ui.utils.SearchField
import com.example.news.ui.theme.Article_loading_card
import com.example.news.ui.theme.Head_SearchBar
import com.example.news.ui.theme.Loading_Card
import com.example.news.ui.theme.LongCard
import com.example.news.ui.theme.ShortCard
import com.example.news.ui.viewmodel.NewsAppViewModel

// 注意！你不应该在Screen部分更改State

/*TODO 这个SearchScreen是用于显示搜索结果的 -> 马小乐
    请你利用searchTable来
* */

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsAppViewModel = NewsAppViewModel()
) {
    var inputValue by remember { mutableStateOf("") }
    val input = inputValue ?: ""

    val searchTableUiState = viewModel.searchTableUiState
    //listData应该是根据输入的string查询相关的新闻,跟上面这个searchTableUiState有关吧
    val listData = (0..5).toList()

    Box {
        Image(
            painterResource(R.drawable.main_one),
            contentDescription = "background_img",
            contentScale = ContentScale.Crop
        )
        Column() {
            SearchField(
                text = input,
                onValueChange = { inputValue = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp, top = 20.dp, end = 50.dp)
                    .height(40.dp)
                    .background(
                        Color.White,
                        shape = androidx.compose.material.MaterialTheme.shapes.medium
                    )
                    .padding(horizontal = 16.dp),
                hint = "搜索热门新闻",
                startIcon = R.drawable.searchicon,
                iconSpacing = 16.dp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            //添加根据输入的信息显示内容 没有搜到就一直是Loading_card
            LazyColumn(content = {
                items(listData){
                    Spacer(modifier = Modifier.height(20.dp))
                    //Loading_Card()
                    //Article_loading_card()
                    LongCard()

                }
            })
        }

    }
}