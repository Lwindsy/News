package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.ui.utils.ArticleScreenBar
import com.example.news.ui.utils.ArticleScreenTop


// 注意！你不应该在Screen部分更改State

/* TODO -> 王松
    ArticleUiState直接用于此screen，利用其来显示文章
    注意这里的底部Bar应该做到：点击评论按钮就把CommentScreen展现出来。至于如何动画出现，请用AnimatedVisibility
    文档：https://developer.android.google.cn/jetpack/compose/animation?hl=zh-cn#animatedvisibility
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier
) {
    var inputValue by remember { mutableStateOf("") }
    val input = inputValue ?: ""

    Box {
        Image(
            painterResource(R.drawable.main_one),
            contentDescription = "background_img",
            contentScale = ContentScale.Crop
        )
        Scaffold(
            topBar = {ArticleScreenTop()},
            bottomBar = {
                ArticleScreenBar(value = input, onValueChange = { inputValue = it })
            }
        ) {
            LazyColumn(contentPadding = it) {
                items(50) {
                    Text(text = "测试")
                }
            }
        }
    }

}