package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.news.R
import com.example.news.data.SearchTableUiState
import com.example.news.ui.utils.SearchField
import com.example.news.ui.theme.LongCard
import com.example.news.ui.viewmodel.NewsAppViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsAppViewModel = NewsAppViewModel(),
    onArticleCardClick:(String) -> Unit = {},
    onReturnClicked: () -> Unit = {}
) {
    var inputValue by remember { mutableStateOf("") }
    val input = inputValue

    val searchTableState = viewModel.searchTableUiState

    Box {
        Image(
            painterResource(R.drawable.main_one),
            contentDescription = "background_img",
            contentScale = ContentScale.Crop
        )
        Column {
            Row(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp)
            ){
                Image(
                    painterResource(R.drawable.back_icon),
                    contentDescription = "返回图标",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .clickable {
                            onReturnClicked()
                        }
                )
                SearchField(
                    text = input,
                    onValueChange = { inputValue = it },
                    modifier = Modifier
                        .fillMaxWidth()
//                        .padding(start = 50.dp, top = 20.dp, end = 50.dp)
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
            }
            Spacer(modifier = Modifier.height(20.dp))
            //添加根据输入的信息显示内容 没有搜到就一直是Loading_card

            when (searchTableState) {
                is SearchTableUiState.Success -> {
                    LazyColumn(content = {
                        items(searchTableState.searchTable) {
                            Spacer(modifier = Modifier.height(20.dp))
                            LongCard(it, onArticleCardClick = onArticleCardClick)
                        }
                    })
                }

                is SearchTableUiState.Loading -> {
                    /* TODO -> szl 设置空信息*/
                }

                else -> {

                }
            }
        }

    }
}