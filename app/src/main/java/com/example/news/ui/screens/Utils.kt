package com.example.news.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    /* 状态提升 */
    value: String,                  // 当前要显示的值
    onValueChange: (String) -> Unit,// 值更改时触发，以便可以在其他位置更新状态
    modifier: Modifier = Modifier

) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(20)),
        singleLine = true,          // 水平滑动
        value = value,              // 框中的值
        onValueChange = onValueChange,

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    value: String,                  // 当前要显示的值
    onValueChange: (String) -> Unit,// 值更改时触发，以便可以在其他位置更新状态
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(20)),
        singleLine = true,          // 水平滑动
        value = value,              // 框中的值
        onValueChange = onValueChange,
        visualTransformation = PasswordVisualTransformation()
    )
}