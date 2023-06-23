package com.example.news.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.model.Affirmation
import com.example.news.R

/* TODO UserUiState用于此screen */
// 注意！你不应该在Screen部分更改State

/**
 * affirmationList -- 后续改成文章的组合项
 * followAmountPe -- 关注人数
 * likeAmount -- 点赞人数
 * reviewAmount -- 评论人数
 * personalSignature -- 个性签名，就是头像后面的名字和骚话
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    affirmationList: List<Affirmation>,
    followAmountPe: String,
    likeAmount: String,
    reviewAmount: String,
    personalSignature: String,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = { PageBottom() }
    ) {

        LazyColumn(contentPadding = it) {

            /* 两个按钮 */
            item { Spacer(modifier = Modifier.height(30.dp)) }

            /* 人物头像 */
            item {
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp)
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
                    androidx.compose.material3.Text(
                        modifier = Modifier
                            .padding(top = 14.dp),
                        text = personalSignature,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

            /* 关注等信息 */
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                    verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
                ) {
                    androidx.compose.material3.Text(
                        text = stringResource(R.string.profile_follow),
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    androidx.compose.material3.Text(
                        text = stringResource(R.string.profile_like),
                        fontSize = 18.sp,
                    )

                    Spacer(modifier = Modifier.width(40.dp))
                    androidx.compose.material3.Text(
                        text = stringResource(R.string.profile_review),
                        fontSize = 18.sp,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                    verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
                ) {
                    androidx.compose.material3.Text(
                        text = followAmountPe,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    androidx.compose.material3.Text(
                        text = likeAmount,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.width(40.dp))
                    androidx.compose.material3.Text(
                        text = reviewAmount,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                MyDivider()     // 分割线
                Spacer(modifier = Modifier.height(30.dp))

            }
            /* 我的关注列表 */
            item {
                androidx.compose.material3.Text(
                    text = stringResource(R.string.profile_following),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                    verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
                ) {
                    repeat(5) {
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
                }


                MyDivider() // 分割线
                Spacer(modifier = Modifier.height(30.dp))
            }

            /* 收藏夹 */
            item {

                androidx.compose.material3.Text(
                    text = stringResource(R.string.profile_favorites),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            items(affirmationList) { affirmation ->
                CollectCard(
                    affirmation = affirmation,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

/**
 * 一个收藏项，测试使用
 */
@Composable
fun CollectCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(id = affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            androidx.compose.material3.Text(
//                text = LocalContext.current.getString(affirmation.stringResourceId),
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        thickness = 0.5.dp,     //设置分割线的高度
        color = Color.Gray,     //设置分割线的颜色
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    )
}

@Composable
fun PageBottom(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.Center,     //设置水平居中对齐
        verticalAlignment = Alignment.CenterVertically  //设置垂直居中对齐
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_icon_light),
            contentDescription = "首页",
            modifier = Modifier
                .clickable {
                    /* TODO
                    * 点击触发首页
                    * */
                    Log.i("ws", "去首页")
                }
        )

        Spacer(modifier = Modifier.width(170.dp))
        Image(
            painter = painterResource(id = R.drawable.people_icon_light),
            contentDescription = "个人主页",
            modifier = Modifier
                .clickable {
                    /* TODO
                    * 点击触发首页
                    * */
                    Log.i("ws", "个人主页")
                }
        )
    }
}