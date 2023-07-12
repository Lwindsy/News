package com.example.news.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class SignUpInfoUiState(
    val signUpResult: Boolean = false,
    val displayCheckResult: Boolean = false,
    val displayIdExistedMsg: Boolean = false,
    val displayIdNullMsg: Boolean = false,
    val displaySignUpSuccess: Boolean = false,
)
