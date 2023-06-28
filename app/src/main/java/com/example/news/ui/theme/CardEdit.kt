package com.example.news.ui.theme

import android.content.ContentValues.TAG
import android.content.Intent
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import com.example.news.R
import com.example.news.data.item.ArticleItem
import com.example.news.data.item.CommentItem
import com.example.news.ui.AllScreen
import com.example.news.ui.screens.ArticleScreen
import org.w3c.dom.Text

@OptIn(ExperimentalFoundationApi::class)
@Composable
//世界新闻这里选择
fun ShortCard(
    articleItem: ArticleItem,
    onArticleCardClick: (String) -> Unit = {}
){
    val painter = painterResource(id = R.drawable.main_one)
    /*val enableState by remember {
        mutableStateOf<Boolean>(true)
    }*/
    Card(
        modifier = Modifier
            .size(width = 160.dp, height = 160.dp)
            .combinedClickable(
                /*enabled = enableState,*/
                /* TODO -> szl
                *   加个长按变大效果 */
                onLongClick = {
                    Log.d(TAG, "发生长按点击操作了～")
                },
                onDoubleClick = {
                    Log.d(TAG, "发生双击操作了～")
                },
                onClick = {
                    onArticleCardClick(articleItem.articleId)
                }
            ),
        shape = RoundedCornerShape(15.dp)
    ) {

        Box(modifier = Modifier.height(180.dp)) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 160.dp, height = 160.dp),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            )
            {
                Column() {
                    Text(
                        articleItem.title,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        articleItem.releaseTime,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 10.sp
                        )
                    )
                }
            }

        }
    }
}
//校园看点部分的显示
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LongCard(
    articleItem: ArticleItem,
    onArticleCardClick: (String) -> Unit = {}
){
    val painter = painterResource(id = R.drawable.main_one)
    Spacer(modifier = Modifier.width(5.dp))
    Card(
        modifier = Modifier
            .size(width = 390.dp, height = 160.dp)
            .combinedClickable(
                /*enabled = enableState,*/
                /* TODO -> szl
                *   加个长按变大效果 */
                onLongClick = {
                    Log.d(TAG, "发生长按点击操作了～")
                },
                onDoubleClick = {
                    Log.d(TAG, "发生双击操作了～")
                },
                onClick = {
                    onArticleCardClick(articleItem.articleId)
                }
            ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 50.dp,
        ),

    ) {
            Box(modifier = Modifier.height(160.dp)) {
                Row() {
                    Box(modifier = Modifier.size(width = 160.dp, height = 160.dp),
                        contentAlignment = Alignment.BottomStart) {
                        Image(
                            painter = painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(width = 160.dp, height = 160.dp),
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Box(
                        modifier = Modifier.size(width = 230.dp, height = 160.dp),
                        contentAlignment = Alignment.TopStart
                    )
                    {
                        Column() {
                            Spacer(modifier = Modifier.height(5.dp))
                            Box(modifier = Modifier.size(width = 230.dp, height = 20.dp)) {
                                Text(
                                    text = articleItem.type,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 16.sp
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier = Modifier.size(width = 230.dp, height = 85.dp)) {
                                Text(
                                    text = articleItem.title,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 20.sp
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier = Modifier.size(width = 230.dp, height = 20.dp)) {
                                Text(
                                    text = articleItem.authorName + articleItem.releaseTime,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 15.sp
                                    )
                                )
                            }
                        }
                    }

                }
            }
    }
}
//
@Composable
fun Loading_Card(){
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
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 50.dp,)
    ) {
        Column() {
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.height(160.dp)) {
                Row() {
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(

                        modifier = Modifier
                            .height(145.dp)
                            .width(150.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color.Gray.copy(alpha = alpha))

                        //contentAlignment = Alignment.BottomStart,
                    ) {
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier.size(width = 185.dp, height = 160.dp),
                        contentAlignment = Alignment.TopStart
                    )
                    {
                        Column() {
                            Spacer(modifier = Modifier.height(5.dp))
                            Box(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(185.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .background(Color.Gray.copy(alpha = alpha)),
                            ) {}
                            Spacer(modifier = Modifier.height(15.dp))
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(185.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .background(Color.Gray.copy(alpha = alpha)),
                            ) {}
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(185.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .background(Color.Gray.copy(alpha = alpha)),
                            ) {}
                        }
                    }

                }
            }
        }
    }
}
@Composable
fun Article_loading_card(){
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
        modifier = Modifier.size(width = 400.dp, height =700.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 50.dp,)
    ) {
        Column() {
            Spacer(modifier = Modifier.height(8.dp))
            Box( modifier = Modifier
                .height(120.dp)
                .width(380.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
                }
            Spacer(modifier = Modifier.height(30.dp))
            Box( modifier = Modifier
                .height(250.dp)
                .width(380.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box( modifier = Modifier
                .height(350.dp)
                .width(380.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
             }
            }
        }
    }
@Composable
fun profile_loading_card(){
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
        modifier = Modifier.size(width = 400.dp, height =700.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 50.dp,)
    ) {
        Column() {
            Spacer(modifier = Modifier.height(8.dp))
            Box( modifier = Modifier
                .height(120.dp)
                .width(380.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box( modifier = Modifier
                .height(130.dp)
                .width(380.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box( modifier = Modifier
                .height(30.dp)
                .width(185.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box( modifier = Modifier
                .height(30.dp)
                .width(185.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray.copy(alpha = alpha)),) {
            }
        }
    }
}

@Composable
fun ShowCommentsCard(
    modifier: Modifier = Modifier,
    comment: CommentItem
) {

    Card(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Row(
            modifier = modifier
                .background(color = colorResource(id = R.color.PurpleGrey80))
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.Start,//设置水平居中对齐
            verticalAlignment =  Alignment.Top
        ) {
            /*用户昵称*/
            Text(
                // text = name + "："
                text = comment.userId + "：",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 15.dp)
            )
            /*评论*/
            Text(
                // text = "comment"
                text = comment.commentText,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 15.dp)
            )

        }
    }
}



@Preview
@Composable
fun pre(){
    Article_loading_card()
}