package com.example.news.ui.screens

import android.app.Activity
import android.app.Notification.MessagingStyle.Message
import android.content.ContentValues.TAG
import android.content.Intent
import android.provider.CalendarContract.Colors
import android.provider.Telephony.MmsSms.PendingMessages
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.MainActivity
import com.example.news.R
import com.example.news.ui.theme.CustomEdit
import com.example.news.ui.theme.MyTextField
import com.example.news.ui.theme.NewsTheme

/* TODO
*   ①不用管search窗口，那是NewsBar的活儿
*   ②注意“世界新闻"需要是一个LazyRow可组合项（可横向滚动）
*   ③底下的新闻列表/新闻分类也需要是LazyColumn/LazyRow可组合项
*   ④两个新闻列表各写一个Card用于显示文章信息
*   ⑤会有一个函数返回一个Article对象用于给Card提供信息，直接调用即可*/

// 注意！你不应该在Screen部分更改State
@Composable
fun HomePageScreen() {
    //img = artilce_img 这个地方应该是个img集合到时根据ID显示图片
    val painter = painterResource(id = R.drawable.img)
    val painter1 = painterResource(id = R.drawable.img)
    //图片的描述 也可忽视这个
    val des = "this is android test"
    //title = article_title 也应该是个集合，依次显示
    val title = "This is Title of image"

    //滑动和下拉只显示六个
    val listData = (0..5).toList()
    val listData1 = (0..5).toList()
    //后面的大标题、小标题、事件都是要调用数据库显示的
        //var searchText = "lizi"
    Column {
        //搜索框设置
        Box(modifier = Modifier
            .width(400.dp)
            .height(70.dp)
            .background(Color.White),){
            CustomEdit(
                //这个地方应该是根据输入的文本显示相应文章
                //text = searchText,
                onValueChange = {
                    //searchText = it
                },
                hint = "习近平在金砖国家领导人第十四次会晤上的讲话",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)
                    .height(40.dp)
                    .background(Color(0xBCE9E9E9), shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                textStyle = TextStyle.Default,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )

        }
        //世界新闻
        Text(
            text = "世界新闻",
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(16.dp))
        //向右滑动
        LazyRow(content = {
            items(listData){
                Spacer(modifier = Modifier.width(5.dp))
                Card(
                    modifier = Modifier.size(width = 175.dp, height = 160.dp),
                    shape = RoundedCornerShape(15.dp),
                ) {
                    Box(modifier = Modifier.height(200.dp)) {
                        Image(
                            painter = painter,
                            contentDescription = des,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(width = 175.dp, height = 160.dp),
                        )
                        //拉渐变
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black
                                        ),
                                        startY = 300f//数据越大黑色越少
                                    )
                                )
                        ) {
                            Box(modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                                contentAlignment= Alignment.BottomEnd
                            ) {
                                Text(
                                    title,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 16.sp
                                    )
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        })
        Spacer(modifier = Modifier.height(10.dp))
        //校园看点
        Text(
            text = "校园看点",
            color = Color.Black,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(16.dp))
        //分类框
        Box(modifier = Modifier
            .width(400.dp)
            .height(80.dp)
            .background(Color.White),){
            Row() {
                Button(
                    onClick = { /*println("点击了按钮") */ },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 8.dp,
                        bottomEnd = 8.dp
                    ) ,
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "通知")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { /*println("点击了按钮") */ },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "热门")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { /*println("点击了按钮") */ },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "活动")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { /*println("点击了按钮") */ },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart =8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "考试")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { /*println("点击了按钮") */ },
                    shape = RoundedCornerShape(//圆角
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart =8.dp,
                        bottomEnd = 8.dp
                    ),
                    modifier = Modifier
                        .width(76.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBCE9E9E9),
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "表彰")
                }
            }
        }
        //向下滑动
        Box(
            modifier = Modifier
                .width(400.dp)
                .height(375.dp)
                .background(Color.White),
        ) {
            LazyColumn(
                content = {
                    items(listData1) {
                        Box(
                            modifier = Modifier
                                .width(400.dp)
                                .height(185.dp)
                                .background(Color.White)
                        ) {
                            Row() {
                                Card(
                                    modifier = Modifier.size(width = 160.dp, height = 160.dp),
                                    shape = RoundedCornerShape(15.dp),
                                ) {
                                    Box(modifier = Modifier.height(180.dp)) {
                                        Image(
                                            painter = painter1,
                                            contentDescription = des,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.size(width = 160.dp, height = 160.dp),
                                        )
                                        //拉渐变
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(
                                                    brush = Brush.verticalGradient(
                                                        colors = listOf(
                                                            Color.Transparent,
                                                            Color.Black
                                                        ),
                                                        startY = 300f//数据越大黑色越少
                                                    )
                                                )
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(16.dp),
                                            contentAlignment = Alignment.BottomStart
                                        )
                                        {
                                            Text(
                                                title,
                                                style = TextStyle(
                                                    color = Color.White,
                                                    fontSize = 16.sp
                                                )
                                            )
                                        }

                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Box() {
                                    Column() {
                                        Text(text = "小标题")
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(text = "大标题")
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(text = "时间")
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                })
        }
        //主页按钮和用户按钮
        Box() {
            Row() {
                Spacer(modifier = Modifier.width(80.dp))
                Button(
                    onClick = { /*TODO*/ },
                    //colors = ButtonColors,
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = "Localized description",
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                    )

                }
                Spacer(modifier = Modifier.width(100.dp))
                Button(
                    onClick = { /*TODO*/ },
                    //colors = ButtonColors,
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Icon(
                        Icons.Rounded.Person,
                        contentDescription = "Localized description",
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                    )
                }
            }
        }
    }
}









@Preview
@Composable
fun PreviewHomePageScreen(){

}

@Composable
fun prev1() {
    NewsTheme {

    }
}