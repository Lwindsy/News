package com.example.news.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R

/* TODO 按照设计图写好此页面
*       不需要管ButtonClicked如何实现的 */

// 注意！你不应该在Screen部分更改State

// 注意，Screen的参数定义一律按照👇这样子来.不是函数的参数全部小写字母，否则驼峰命名法.
// 另外，你应该将screen内所有的组件写为无状态组件.参照https://developer.android.com/codelabs/basic-android-kotlin-compose-using-state?hl=zh-cn&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%3Fhl%3Dzh-cn%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-using-state#11
// 这个screen需要接收的UiState直接在参数里定义，在NewsApp调用处把Ui+State传进去.

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var username by remember { mutableStateOf("") }
        val uname = username ?: ""       // 如果为空就置值为 ""

        var password by remember { mutableStateOf("") }
        val pwd = password ?: ""

        var checkPassword by remember { mutableStateOf("") }
        val cpwd = password ?: ""

        // 外层使用 Box 布局包裹
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
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(Modifier.height(30.dp))  // 增加间隔

                Text(
                    text = stringResource(R.string.signUp_head),
                    color = Color.Black,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Spacer(Modifier.height(30.dp))  // 增加间隔

                Text(
                    text = stringResource(R.string.signUp_username),
                    color = Color.Black
                )
                InputField_SignUp(
                    value = username,
                    onValueChange = { username = it }
                )

                Text(
                    text = stringResource(R.string.signUp_password),
                    color = Color.Black
                )
                InputField_SignUp(
                    value = pwd,
                    onValueChange = { password = it }
                )

                Text(
                    text = stringResource(R.string.signUp_password_two),
                    color = Color.Black
                )
                InputField_SignUp(
                    value = cpwd,
                    onValueChange = { checkPassword = it }
                )

                Spacer(Modifier.height(10.dp))  // 增加间隔

                Text(
                    text = stringResource(R.string.signUp_terms),
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.height(100.dp))  // 增加间隔

                Button(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = stringResource(R.string.signUp_button))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField_SignUp(
    /* 状态提升 */
    value: String,                  // 当前要显示的值
    onValueChange: (String) -> Unit,// 值更改时触发，以便可以在其他位置更新状态
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,          // 水平滑动
        value = value,              // 框中的值
        onValueChange = onValueChange,
    )
}