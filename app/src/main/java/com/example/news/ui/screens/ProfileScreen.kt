package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R

/* TODO UserUiState用于此screen */
// 注意！你不应该在Screen部分更改State

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
    ) {
//        Image(
//            painterResource(R.drawable.main_one),
//            contentDescription = "background_img",
//            contentScale = ContentScale.Crop
//        )

        Column {
            /* 两个按钮 */


            Spacer(modifier = Modifier.height(30.dp))
            /*
            * 人物头像
            * */
            Row {
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.head_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding(top = 14.dp),
                    text = "张三\n我是法外狂徒",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            /*
            * 关注等信息
            * */

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
            ) {
                Text(
                    text = "关注",
                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "点赞",
                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "评论",
                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp),
                horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
            ) {
                Text(
                    text = "110",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "120",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "119",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            /*
            * 我的关注列表
            * */

            Text(
                text = "我的关注",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
            ) {
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.head_icon),
                    contentDescription = null
                )
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.head_icon),
                    contentDescription = null
                )
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.head_icon),
                    contentDescription = null
                )
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.head_icon),
                    contentDescription = null
                )
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.head_icon),
                    contentDescription = null
                )

            }

            Spacer(modifier = Modifier.height(10.dp))
            /*
            * 收藏夹
            * */
            Text(
                text = "我的收藏",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                modifier = modifier
//                    .size(dimensionResource(R.dimen.image_size))
                    .padding(dimensionResource(R.dimen.padding_small)),
//                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable._604499740366),
                contentDescription = null
            )

        }
    }
}