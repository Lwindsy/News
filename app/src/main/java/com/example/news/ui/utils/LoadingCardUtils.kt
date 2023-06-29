package com.example.news.ui.utils

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * 个人主页收藏夹加载
 */
@Composable
fun ProfileCollectedLoadingCard(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    // 这个 alpha 也是一种State，现在alpha会按照设置好的数值来回变动
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            // 来回变
            repeatMode = RepeatMode.Reverse
        )
    )

    Spacer(modifier = Modifier.width(5.dp))
    Card(
        modifier = Modifier.size(width = 390.dp, height = 160.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 50.dp,
        )
    ) {
        Box(
            modifier = Modifier
                .height(160.dp)
                .background(Color.Gray.copy(alpha = alpha))
        ) {
            Row {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .size(width = 200.dp, height = 160.dp)
                        .background(Color.Gray.copy(alpha = alpha))
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 160.dp, height = 160.dp)
                            .background(Color.Gray.copy(alpha = alpha)),
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    contentAlignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(width = 185.dp, height = 160.dp)
                        .background(Color.Gray.copy(alpha = alpha))
                )
                {
                    Column {
                        Spacer(modifier = Modifier.height(20.dp))

                        Box(
                            modifier = Modifier
                                .background(Color.Gray.copy(alpha = alpha))
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .background(Color.Gray.copy(alpha = alpha))
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Box(
                            modifier = Modifier
                                .background(Color.Gray.copy(alpha = alpha))
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun HeadArticleCardLoading(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    // 这个 alpha 也是一种State，现在alpha会按照设置好的数值来回变动
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            // 来回变
            repeatMode = RepeatMode.Reverse
        )
    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 82.dp, max = 84.dp)
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
                    .size(80.dp)
                    .clip(CardDefaults.shape)
                    //此处copy函数为重点！！它会让这个组件的颜色随着alpha的不断变化而变化，从而达到“呼吸一样的效果”
                    .background(Color.Gray.copy(alpha = alpha))
            )
            Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
                Box(
                    modifier = modifier
                        .padding(start = 4.dp, top = 5.dp, bottom = 5.dp)
                        .height(25.dp)
                        .width(200.dp)
                        .clip(CardDefaults.shape)
                        .background(Color.Gray.copy(alpha = alpha))
                )
                Row(modifier = modifier.padding(top = 5.dp, bottom = 7.dp)) {
                    Box(
                        modifier = modifier
                            .padding(start = 4.dp, end = 4.dp)
                            .height(25.dp)
                            .width(50.dp)
                            .clip(CardDefaults.shape)
                            .background(Color.Gray.copy(alpha = alpha))
                    )
                    Box(
                        modifier = modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .height(25.dp)
                            .width(50.dp)
                            .clip(CardDefaults.shape)
                            .background(Color.Gray.copy(alpha = alpha))
                    )
                }
            }
        }
    }
}