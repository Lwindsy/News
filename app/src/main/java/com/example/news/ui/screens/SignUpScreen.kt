package com.example.news.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
    onSignUpButtonClicked: () -> Unit = {},
) {

}