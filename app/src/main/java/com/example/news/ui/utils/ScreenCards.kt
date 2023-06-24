package com.example.news.ui.utils

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.model.Affirmation
import com.example.news.R

@Composable
fun LongCard() {
    val painter = painterResource(id = R.drawable.z)
    Spacer(modifier = Modifier.width(5.dp))
    Card(
        modifier = Modifier.size(width = 390.dp, height = 160.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 50.dp,
        )
    ) {
        Box(modifier = Modifier.height(160.dp)) {
            Row() {
                Box(
                    modifier = Modifier.size(width = 200.dp, height = 160.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(width = 160.dp, height = 160.dp),
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier.size(width = 185.dp, height = 160.dp),
                    contentAlignment = Alignment.TopStart
                )
                {
                    Column() {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            "文章分类",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            "文章题目",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 30.sp
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            "文章作者+时间",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        )
                    }
                }

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