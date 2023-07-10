package com.example.news.ui.screens

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.data.item.UserItem
import com.example.news.ui.utils.InputField
import com.example.news.ui.utils.PasswordField
import com.example.news.ui.viewmodel.NewsAppViewModel


/*TODO 加上注册按钮*/
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLogInButtonClicked: (UserItem) -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {},
    onLogInSuccess: () -> Unit = {},
    newsAppViewModel: NewsAppViewModel,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var userId by remember { mutableStateOf("") }
        val uId = userId     // 如果为空就置值为 ""

        var password by remember { mutableStateOf("") }
        val pwd = password

        val userState by newsAppViewModel.userUiState.collectAsState()

        Image(
            painterResource(R.drawable.main_one),
            contentDescription = "background_img",
            contentScale = ContentScale.Crop
        )

        /*
        * 页面布局
        * */
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(Modifier.height(80.dp))  // 增加间隔

            Text(
                text = stringResource(R.string.login_head_one),
                color = Color.Black,
                fontSize = 36.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.login_head_two),
                color = Color.Black,
                fontSize = 36.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,//设置水平居中对齐
                verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
            ) {
                Text(
//                    text = "没有账号？",
                    text = "",
                    color = Color.Black
                )
                Text(
//                    text = stringResource(R.string.login_head_three),
                    text = "",
                    color = Color.Blue,
                    modifier = Modifier
                        .clickable(onClick = onSignUpButtonClicked)
                )
            }
            Spacer(Modifier.height(30.dp))  // 增加间隔

            when (userState.success.toString()) {
                "1" -> {
                    onLogInSuccess()
                    Log.d(ContentValues.TAG, "HI~~~")
                }

                "0" -> {
                    Column(
                        modifier = Modifier
                            .height(30.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "用户名或密码错误！请检查后重新输入",
                            color = Color.Red,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                        )
                    }
                }

                else -> {

                }
            }

            Text(
                text = stringResource(R.string.userId),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 15.dp)
            )
            InputField(
                value = userId,
                onValueChange = { userId = it }
            )

            Text(
                text = stringResource(R.string.login_password),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 15.dp)
            )
            PasswordField(
                value = pwd,
                onValueChange = { password = it }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,     // 水平居中
                verticalAlignment = Alignment.CenterVertically  // 垂直居中
            ) {
                /* TODO
                    需要加一个复选框，记住当前用户情况
                */
                Text(
                    text = "",
//                    text = stringResource(R.string.login_remember),
                    color = Color.Black,
                )

                Spacer(Modifier.width(180.dp))  // 增加间隔

                Text(
                    text = "",
//                    text = stringResource(R.string.login_helper),
                    color = Color.Black,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .clickable {
                            Log.i("1", "忘记密码")
                        }
                )
            }

            Spacer(Modifier.height(10.dp))

            // login button
            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .size(width = 280.dp, height = 50.dp),
                onClick = {
                    onLogInButtonClicked(
                        UserItem(
                            userId = uId,
                            password = pwd
                        )
                    )
                    if (userState.success == 1L) {
                        onLogInSuccess()
                    }
                },
                shape = AbsoluteRoundedCornerShape(
                    topLeft = 10.dp,
                    topRight = 10.dp,
                    bottomLeft = 10.dp,
                    bottomRight = 10.dp
                )
            ) {
                Text(
                    text = stringResource(R.string.login_button),
                    fontSize = 24.sp
                )
            }

            Spacer(Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                SignUpClickableText(onSignUpButtonClicked)
            }
        }
    }
}

@Composable
fun SignUpClickableText(
    onSignUpButtonClicked: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Gray,
                fontSize = 14.sp,
            )
        ){
            append("没有账号？去")
        }

//        // We attach this *URL* annotation to the following content
//        // until `pop()` is called
//        pushStringAnnotation(
//            tag = "URL",
//            annotation = "https://developer.android.com"
//        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        ) {
            append("注册")
        }

//        pop()
    }

    ClickableText(
        text = annotatedText,
        // this offset indicates the index of the clickableText of where you click
        onClick = { offset ->
            if(annotatedText[offset-1] == '注' || annotatedText[offset-1] == '册'){
                onSignUpButtonClicked()
            }
        }
    )
}