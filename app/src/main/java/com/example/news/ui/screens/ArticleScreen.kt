package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.ui.utils.ArticleScreenBar
import com.example.news.ui.utils.ArticleScreenTop
import com.example.news.ui.viewmodel.NewsAppViewModel


// 注意！你不应该在Screen部分更改State
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    viewModel: NewsAppViewModel,
    modifier: Modifier = Modifier,
    onCommentClick: () -> Unit = {}
) {
    var inputValue by remember { mutableStateOf("") }
    val input = inputValue ?: ""

    val articleState by viewModel.articleUiState.collectAsState()

    Box {
        Image(
            painterResource(R.drawable.main_one),
            contentDescription = "background_img",
            contentScale = ContentScale.Crop
        )
        Scaffold(
            /*TODO -> szl 点击评论按钮上传评论*/
            bottomBar = {
                ArticleScreenBar(value = input, onValueChange = { inputValue = it }, onCommentClick = onCommentClick)
            }
        ) {
            LazyColumn(
                contentPadding = it,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.bar)),
            ) {
                item { Spacer(modifier = Modifier.height(10.dp)) }
                /* 标题 */
                item {
                    Text(
                        text = articleState.articleItem.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp)
//                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }
                item { Spacer(modifier = Modifier.height(10.dp)) }

                /* 作者 */
                item {
                    Text(
                        text = articleState.articleItem.authorName,
                        color = Color.Black,

                        modifier = Modifier.padding(start = 15.dp),

                        )
                }


                item {
                    Image(
                        painter = painterResource(id = R.drawable.xi),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .size(height = 300.dp, width = 200.dp)
                            .padding(start = 15.dp, end = 15.dp)
                    )

                }

                /* 二级标题 */
                /*item {
                    Text(text =
                    "习近平：我们将扩大合作空间，加大对共建“一带路”" +
                            "国家服务业发展的支持，同世界共享中国技术发展成果。",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black,

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )
                }*/

                item { Spacer(modifier = Modifier.height(10.dp)) }


                /* 正文 */
                item{
                    Text(
                        text = articleState.articleItem.bodyText,
                        color = Color.Black,

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
//                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }

}