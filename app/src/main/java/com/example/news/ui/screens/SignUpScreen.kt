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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.example.news.R
import com.example.news.data.item.UserItem
import com.example.news.ui.utils.InputField
import com.example.news.ui.utils.PasswordField
import com.example.news.ui.viewmodel.NewsAppViewModel
import com.example.news.ui.viewmodel.SignUpInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/* TODO
*   ①把inputField里的下划线去掉（未解之谜）
*   ②在注册按钮的onclick那，使注册结果返回后才执行接下来的语句（未解之谜）
*   */
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
        val uId = userId

        var password by remember { mutableStateOf("") }
        val pwd = password

        var checkPassword by remember { mutableStateOf("") }
        val cpwd = checkPassword

        val signUpState by viewModel.signUpInfoUiState.collectAsState()
        val displayIdExistedMsg = signUpState.displayIdExistedMsg
        val displayIdNullMsg = signUpState.displayIdNullMsg
        val displayCheckResult = signUpState.displayCheckResult
        val displaySignUpSuccess = signUpState.displaySignUpSuccess

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
                        viewModel.setDisplayMsg(SignUpInfo.ID_NULL,false)
                        viewModel.setDisplayMsg(SignUpInfo.ID_EXISTED,false)
                    },
                )

                if (!signUpState.signUpResult && displayIdExistedMsg) {
                    Text(
                        text = "此账号已存在！请重新输入",
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                    )
                }

                if(displayIdNullMsg){
                    Text(
                        text = "请输入账号！",
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
                        viewModel.setDisplayMsg(SignUpInfo.PWD_CHECK,false)
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
                        viewModel.setDisplayMsg(SignUpInfo.PWD_CHECK,false)
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

                if (displaySignUpSuccess) {
                    Text(
                        text = "注册成功！",
                        color = Color(0xFF3A8846),
                        fontSize = 17.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                    )
                }

                Spacer(Modifier.height(10.dp))

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
                            viewModel.setDisplayMsg(SignUpInfo.PWD_CHECK,true)
                        }else if (userId == ""){
                            viewModel.setDisplayMsg(SignUpInfo.ID_NULL,true)
                        }
                        else {
                            viewModel.viewModelScope.launch {
                                // this function calls a new coroutine to update the signUpState.
                                onSignUpButtonClicked(
                                    UserItem(
                                        userId = userId,
                                        password = pwd
                                    )
                                )
                                // wait for the onSignUpButtonClicked till it finishes
                                delay(200)
                                // sign up successfully
                                if (signUpState.signUpResult) {
                                    onSignUpSuccess()
                                } else {
                                    viewModel.setDisplayMsg(SignUpInfo.ID_EXISTED,true)
                                }
                            }
                        }
                    },
                    shape = AbsoluteRoundedCornerShape(
                        topLeft = 10.dp,
                        topRight = 10.dp,
                        bottomLeft = 10.dp,
                        bottomRight = 10.dp
                    )
                ) {
                    Text(text = stringResource(R.string.signUp_button))
                }

                Spacer(Modifier.height(5.dp))

                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    LogInClickableText(onLogInButtonClicked)
                }
            }
        }
    }
}

@Composable
fun LogInClickableText(
    onLogInButtonClicked: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Gray,
                fontSize = 14.sp,
            )
        ){
            append("已有帐号？去")
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
            append("登录")
        }

//        pop()
    }

    ClickableText(
        text = annotatedText,
        // this offset indicates the index of the clickableText of where you click
        onClick = { offset ->
            if(annotatedText[offset-1] == '登' || annotatedText[offset-1] == '录'){
                onLogInButtonClicked()
            }
        }
    )
}


@Composable
@Preview
fun Pre(

) {
    SignUpScreen()
}