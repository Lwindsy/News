package com.example.news.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.data.UserUiState
import com.example.news.ui.viewmodel.NewsAppViewModel

/* TODO 按照设计图写好此页面(先不用写“记住密码”和“忘记密码”，记住密码需要本地缓存)
*       不需要管ButtonClicked如何实现的 */

// 注意！你不应该在Screen部分更改State

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {},
    onSignUpSuccess: () -> Unit = {},
    viewModel: NewsAppViewModel = NewsAppViewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var username by remember { mutableStateOf("") }
        val uname = username ?: ""       // 如果为空就置值为 ""

        var password by remember { mutableStateOf("") }
        val pwd = password ?: ""

        /*  TODO 利用这个来调用用户是否登录成功： -> 王松
                userUiState.success 为true表示用户登录成功；为false时用户登录失败，且userUiState.failmsg会提供失败信息
                写一个组件用success这个state来控制点击 登录 按钮之后是否打印错误信息；若成功则调用onSignUpSuccess函数（我会写好）。
        */
        val userUiState by viewModel.userUiState.collectAsState()

        Box {
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
                    verticalAlignment =  Alignment.CenterVertically//设置垂直居中对齐
                ) {
                    Text(
                        text = "没有账号？",
                        color = Color.Black
                    )
                    Text(
                        text = stringResource(R.string.login_head_three),
                        color = Color.Blue,
                        modifier = Modifier
                            .clickable(onClick = onSignUpButtonClicked)
                    )
                }
                Spacer(Modifier.height(30.dp))  // 增加间隔

                Text(
                    text = stringResource(R.string.login_username),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
                InputField(
                    value = username,
                    onValueChange = { username = it }
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
                    * 需要加一个复选框，记住当前用户情况
                    * */
                    Text(
                        text = stringResource(R.string.login_remember),
                        color = Color.Black,
                    )

                    Spacer(Modifier.width(180.dp))  // 增加间隔

                    Text(
                        text = stringResource(R.string.login_helper),
                        color = Color.Black,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                /* TODO
                                * 这里可以定义点击事件
                                * */
                                Log.i("1", "忘记密码")
                            }
                    )
                }

                Spacer(Modifier.height(100.dp))  // 增加间隔

                Button(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .size(width = 280.dp, height = 50.dp),
                    onClick = onLogInButtonClicked,
                    shape = AbsoluteRoundedCornerShape(//圆角
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
            }
        }
    }
}

@Composable
fun LoginMessage(
    modifier: Modifier = Modifier
) {

}

@Preview
@Composable
fun PreLogin() {
    LoginScreen()
}