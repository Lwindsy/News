package com.example.news.ui.utils

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R


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

    // 具体的格式需要对照具体的样式
    val painter = painterResource(id = R.drawable.z)
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
            Row() {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .size(width = 200.dp, height = 160.dp)
                        .background(Color.Gray.copy(alpha = alpha))
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 160.dp,height = 160.dp)
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
                    Column() {
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