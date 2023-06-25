package com.example.news.ui.utils

import android.util.Log
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R


/*************** Top Bar ****************/

@Composable
fun ArticleScreenTop(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White)
            .padding(start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,//设置水平居中对齐
        verticalAlignment = Alignment.CenterVertically,//设置垂直居中对齐
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = "",
            modifier = Modifier
                .clickable { }
        )
        Spacer(modifier = Modifier.width(260.dp))
        Image(
            painter = painterResource(id = R.drawable.share_icon),
            contentDescription = "",
            modifier = Modifier
                .clickable { }
        )
    }
}

/*************** Bottom Bar ****************/

@Composable
fun ArticleScreenBar(
    /* 状态提升 */
    value: String,                  // 当前要显示的值
    onValueChange: (String) -> Unit,// 值更改时触发，以便可以在其他位置更新状态
    onCommentClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.Center,//设置水平居中对齐
        verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 30.dp)
                .width(100.dp),
        )
        Image(
            painter = painterResource(id = R.drawable.comment),
            contentDescription = "",
            modifier = Modifier
                .clickable {
                    onCommentClick()
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.like_icon),
            contentDescription = "",
            modifier = Modifier
                .padding(end = 30.dp)
                .clickable { }
        )
    }
}

@Composable
fun ProfileBottomBar(
    modifier: Modifier = Modifier,
    onProfileClick:() -> Unit = {},
    onHomeClick:() -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.Center,//设置水平居中对齐
        verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_icon_light),
            contentDescription = "",
            modifier = Modifier
                .clickable {
                    onHomeClick()
                }
        )

        Spacer(modifier = Modifier.width(170.dp))
        Image(
            painter = painterResource(id = R.drawable.people_icon_night),
            contentDescription = "",
            modifier = Modifier
                .clickable {
                    onProfileClick()
                }
        )
    }
}

@Composable
fun HomepageBottomBar(
    modifier: Modifier = Modifier,
    onProfileClick:() -> Unit = {},
    onHomeClick:() -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.Center,//设置水平居中对齐
        verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_icon_night),
            contentDescription = "",
            modifier = Modifier
                .clickable {
                    onHomeClick()
                }
        )

        Spacer(modifier = Modifier.width(170.dp))
        Image(
            painter = painterResource(id = R.drawable.people_icon_light),
            contentDescription = "",
            modifier = Modifier
                .clickable {
                    onProfileClick()
                }
        )
    }
}