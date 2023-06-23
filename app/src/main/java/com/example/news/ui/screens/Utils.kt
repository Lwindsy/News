package com.example.news.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

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
        singleLine = true,          // 单行
        maxLines = 1,               // 最多一行
        value = value,              // 框中的值
        onValueChange = onValueChange,  // 触发事件
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        )
    )
}

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
        singleLine = true,          // 单行
        maxLines = 1,               // 最多一行
        value = value,              // 框中的值
        onValueChange = onValueChange,colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

}