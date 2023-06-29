package com.example.news.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import com.example.news.data.ArticleItem
import com.example.news.ui.theme.NewsTheme

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchTable: List<ArticleItem>
)
{
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
    }
}

/**
 * 文本区
 */
@Composable
fun SearchScreenText(modifier: Modifier = Modifier, searchTable: List<ArticleItem>) {
    for (news in searchTable) {
        var title = "$news.title"
        var tag = "$news.tag"
        var releaseTime = "$news.releaseTime"
        Column(
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 14.dp)
                    .padding(bottom = 5.dp)
            )
            Text(
                text = "$tag     $releaseTime\n\n",
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun prev() {
    NewsTheme {
        MainScreen()
    }
}