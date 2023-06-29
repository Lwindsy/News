package com.example.news.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.ui.theme.NewsTheme


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onSignUpButtonClicked: () -> Unit,
    onLogInButtonClicked: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Background_image(
            img_name = R.drawable.main_one,
            onSignUpButtonClicked = onSignUpButtonClicked,
            onLogInButtonClicked = onLogInButtonClicked
        )
    }
}

/**
 * 首页文本区
 */
@Composable
fun MainScreenText(
    modifier: Modifier = Modifier,
    onSignUpButtonClicked: () -> Unit,
    onLogInButtonClicked: () -> Unit
) {
    Column(
        // 设置列布局的高度和宽度设为可用的最大值
        modifier = modifier
            .fillMaxSize()
            .padding(start = 18.dp),
        // 文本元素底部对齐
        verticalArrangement = Arrangement.Bottom,
        // 文本元素水平居中
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.main_title),
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 14.dp)
        )
        Text(
            text = stringResource(R.string.main_description),
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
        MainScreenButton(
            onSignUpButtonClicked = onSignUpButtonClicked,
            onLogInButtonClicked = onLogInButtonClicked
        )
    }
}

/**
 * 首页的按钮
 */
@Composable
fun MainScreenButton(
    modifier: Modifier = Modifier,
    onSignUpButtonClicked: () -> Unit,
    onLogInButtonClicked: () -> Unit
) {
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        // 水平居中
        horizontalArrangement = Arrangement.Center,
        // 垂直居中
        verticalAlignment = Alignment.CenterVertically
    ) {
//        Button(
//            onClick = onSignUpButtonClicked,
//            modifier = Modifier.padding(end = 20.dp)    // 调整两个按钮之间的距离
//        ) {
//            Text(text = "注册")
//        }
        Button(onClick = onLogInButtonClicked) {
            Text(
                text = "登录",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
//                    .fillMaxWidth()
                    .size(width = 160.dp, height = 30.dp)
            )
        }
    }
}

@Composable
fun Background_image(
    @DrawableRes img_name: Int,
    modifier: Modifier = Modifier,
    onSignUpButtonClicked: () -> Unit,
    onLogInButtonClicked: () -> Unit
) {
    // 外层使用 Box 布局包裹
    Box {
        Image(
            painterResource(id = img_name),
            contentDescription = "background_img",
            // 缩放背景
            contentScale = ContentScale.Crop
        )
        MainScreenText(
            onSignUpButtonClicked = onSignUpButtonClicked,
            onLogInButtonClicked = onLogInButtonClicked
        )
    }
}

@Preview
@Composable
fun Prev() {
    NewsTheme {

    }
}