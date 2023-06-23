package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
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

/* TODO ArticleTableUiScreen 里的 searchTable 用于此screen */

// 注意！你不应该在Screen部分更改State

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    var inputValue by remember { mutableStateOf("") }
    val input = inputValue ?: ""

    Box {
        Image(
            painterResource(R.drawable.searchicon),
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
                    .background(Color.White, shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                hint = "搜索热门新闻",
                startIcon = R.drawable.searchicon,
                iconSpacing = 16.dp,
//                textStyle = ,
                // keyboardType -> 半个 inputType; 这里是 Phone
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            )
        }
    }
}