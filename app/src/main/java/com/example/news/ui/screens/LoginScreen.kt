package com.example.news.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R

/* TODO 按照设计图写好此页面(先不用写“记住密码”和“忘记密码”，记住密码需要本地缓存)
*       不需要管ButtonClicked如何实现的 */

// 注意！你不应该在Screen部分更改State

@Composable
fun LoginScreen(
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

        // 外层使用 Box 布局包裹
        Box {
            Image(
                painterResource(R.drawable.main_one),
                contentDescription = "background_img",
                // 缩放背景
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
                    text = "欢迎回到",
                    color = Color.Black,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "理工日报",
                    color = Color.Black,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "没有账号？注册",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.height(30.dp))  // 增加间隔

                Text(
                    text = "用户名",
                    color = Color.Black
                )
                InputField(
                    value = username,
                    onValueChange = { username = it }
                )
                Text(
                    text = "密码",
                    color = Color.Black
                )
                InputField(
                    value = pwd,
                    onValueChange = { password = it }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,     // 水平居中
                    verticalAlignment = Alignment.CenterVertically  // 垂直居中
                ) {
                    Text(
                        text = "记住用户",
                        color = Color.Black,

                        )
                    Spacer(Modifier.width(200.dp))  // 增加间隔

                    Text(
                        text = "忘记密码？",
                        color = Color.Black
                    )
                }

                Spacer(Modifier.height(100.dp))  // 增加间隔

                Button(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "登录")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
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

@Preview
@Composable
fun PreLogin() {

}