package com.example.news.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.news.R
import com.example.news.ui.utils.SearchField

@Composable
fun Head_SearchBar(
    onSearchClick: (String) -> Unit = {}
) {
    var inputValue by remember { mutableStateOf("") }
    val input = inputValue
    Box(modifier = Modifier
        .height(40.dp)
        .clickable { onSearchClick(input) }
    ) {
        SearchField(
            text = input,
            onValueChange = { inputValue = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, top = 20.dp, end = 50.dp)
                .height(40.dp)
                .background(Color.White, shape = MaterialTheme.shapes.medium)
                .padding(horizontal = 16.dp)
                .clickable { onSearchClick(input) },//点击搜索跳转SearchScreen()
            hint = "搜索热门新闻",
            startIcon = R.drawable.searchicon,
            iconSpacing = 16.dp,
//                textStyle = ,
            // keyboardType -> 半个 inputType; 这里是 Phone
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        )
    }
}

@Composable
fun Head_SignupBar() {
    Image(
        painterResource(R.drawable.back_icon),
        contentDescription = "返回图标",
        modifier = Modifier
            .padding(start = 15.dp)
            .clickable {
                Log.i("ws", "back")
            }
    )
}

@Composable
fun Head_ArticleBar(
    onReturnClicked: () -> Unit = {}
) {
    Image(
        painterResource(R.drawable.back_icon),
        contentDescription = "返回图标",
        modifier = Modifier
            .padding(start = 15.dp)
            .clickable {
                onReturnClicked()
            }
    )
}