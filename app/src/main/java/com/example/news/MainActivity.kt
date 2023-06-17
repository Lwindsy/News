package com.example.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.ui.theme.NewsTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Background_image(img_name = R.drawable.main)
                    Main_button_text()
                }
            }
        }
    }
}

/*TODO : 更改样式*/
// hhi

@Composable
fun Background_image(
    @DrawableRes img_name:Int,
    modifier: Modifier = Modifier
){
    Image(painter = painterResource(id = img_name), contentDescription = "background_img")
}

@Composable
fun Main_button_text(
    modifier: Modifier = Modifier
){
    Column {
        Text(text = stringResource(R.string.main_title))
        Text(text = stringResource(R.string.main_description))
        Row(){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "注册")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "登录")
            }
        }
    }
}

@Preview
@Composable
fun prev() {
    NewsTheme{
        Background_image(img_name = R.drawable.main)
        Main_button_text()
    }
}