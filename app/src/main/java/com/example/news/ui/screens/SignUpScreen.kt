package com.example.news.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import androidx.lifecycle.viewModelScope
import com.example.news.R
import com.example.news.data.item.UserItem
import com.example.news.ui.utils.InputField
import com.example.news.ui.utils.PasswordField
import com.example.news.ui.viewmodel.NewsAppViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/* TODO
*   ①注册成功出提示信息
*   ③账号已存在的话也出错误信息( -> 账号已存在会出现网络异常，原因应该是服务器那边的插入出现key冲突异常导致)
*   ④把inputField里的下划线去掉
*   ⑤把登录二字做成像超链接一样的款式*/
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: (UserItem) -> Unit = {},
    onSignUpSuccess: () -> Unit = {},
    onReturnClicked: () -> Unit = {},
    viewModel: NewsAppViewModel = NewsAppViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        // three input variables
        var userId by remember { mutableStateOf("") }
        val uId = userId      // 如果为空就置值为 ""

        var password by remember { mutableStateOf("") }
        val pwd = password

        var checkPassword by remember { mutableStateOf("") }
        val cpwd = checkPassword

        var displayCheckResult by remember { mutableStateOf(false) }
        var displayIdMsg by remember { mutableStateOf(false) }

        val signUpState by viewModel.signUpInfoUiState.collectAsState()

        Box {
            //background image
            Image(
                painterResource(R.drawable.main_one),
                contentDescription = "background_img",
                contentScale = ContentScale.Crop        // 缩放背景
            )


            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.height(18.dp))
                // return button
                Image(
                    painterResource(R.drawable.back_icon),
                    contentDescription = "返回图标",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .clickable {
                            onReturnClicked()
                            Log.i("ws", "back")
                        }
                )

                Text(
                    text = stringResource(R.string.signUp_head),
                    color = Color.Black,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Spacer(Modifier.height(40.dp))  // 增加间隔

                // userId
                Text(
                    text = stringResource(R.string.userId),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
                InputField(
                    value = uId,
                    onValueChange = {
                        userId = it
                        displayIdMsg = false
                    },
                )

                if (!signUpState.signUpResult && displayIdMsg) {
                    Text(
                        text = "此账号已存在！请重新输入",
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                    )
                }

                // password
                Text(
                    text = stringResource(R.string.signUp_password),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
                PasswordField(
                    value = pwd,
                    onValueChange = {
                        password = it
                        displayCheckResult = false
                    },
                )

                // checkPassword
                Text(
                    text = stringResource(R.string.signUp_password_two),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
                PasswordField(
                    value = cpwd,
                    onValueChange = {
                        checkPassword = it
                        displayCheckResult = false
                    },
                )

                if (displayCheckResult) {
                    Text(
                        text = "两次输入密码不一致！请重新输入",
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                    )
                }

                Spacer(Modifier.height(60.dp))

                // information
                Text(
                    text = stringResource(R.string.signUp_terms),
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.height(10.dp))

                //sign up button
                Button(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .size(width = 280.dp, height = 50.dp),
                    onClick = {
                        if (pwd != cpwd) {
                            displayCheckResult = true
                        } else {
                            // this function calls a new coroutine to update the signUpState.
                            onSignUpButtonClicked(
                                UserItem(
                                    userId = userId,
                                    password = pwd
                                )
                            )
                            viewModel.viewModelScope.launch {
                                // wait for the onSignUpButtonClicked till it finishes
                                delay(200)
                                // sign up successfully
                                if (signUpState.signUpResult) {
                                    onSignUpSuccess()
                                } else {
                                    displayIdMsg = true
                                }
                            }
                        }
                    },
                    shape = AbsoluteRoundedCornerShape(//圆角
                        topLeft = 10.dp,
                        topRight = 10.dp,
                        bottomLeft = 10.dp,
                        bottomRight = 10.dp
                    )
                ) {
                    Text(text = stringResource(R.string.signUp_button))
                }

                Spacer(Modifier.height(60.dp))  // 增加间隔

                Text(
                    text = "已有账号？登录", color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            Log.i("ws", "去登录")
                        }
                )
            }
        }
    }
}

@Composable
@Preview
fun Pre(

) {
    SignUpScreen()
}