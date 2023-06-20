package com.example.news.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.news.R
import com.example.news.ui.theme.NewsTheme

// 注意！你不应该在Screen部分更改State
/* 界面的效果应如main.jpg 所示*/

/*TODO : 更改按钮，文字样式*/
@Composable
fun MainScreen(

) {
    Background_image(img_name = R.drawable.main)
    Column {
        Text(text = stringResource(R.string.main_title))
        Text(text = stringResource(R.string.main_description))
        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "注册")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "登录")
            }
        }
    }
}

/* TODO: 更改背景图片 */
@Composable
fun Background_image(
    @DrawableRes img_name: Int,
    modifier: Modifier = Modifier
) {
    Image(painter = painterResource(id = img_name), contentDescription = "background_img")
}

@Preview
@Composable
fun prev() {
    NewsTheme {
        MainScreen()
    }
}