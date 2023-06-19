package com.example.news.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.news.R
import com.example.news.ui.screens.ArticleScreen
import com.example.news.ui.screens.HomePageScreen
import com.example.news.ui.screens.LoginScreen
import com.example.news.ui.screens.MainScreen
import com.example.news.ui.screens.ProfileScreen
import com.example.news.ui.screens.SearchScreen
import com.example.news.ui.screens.SignUpScreen

// for navigation
enum class AllScreen(@StringRes val title: Int){
    Article(title = R.string.Article),
    HomePage(title = R.string.Homepage),
    Login(title = R.string.Login),
    Main(title = R.string.Main),
    Profile(title = R.string.Profile),
    Search(title = R.string.Search),
    SignUp(title = R.string.Signup)
}

@Composable
fun NewsAppBar(
    modifier: Modifier = Modifier,
    currentScreen: AllScreen,
){
    /* TODO 完善这个bar：①针对每一个不同的screen有不同的bar ②样式调好 */
}

fun composable(route: Any, function: () -> Unit) {

}

/*TODO:①完善各个screen的调用（当然，要先把各个Screen完成），包括：{
         1、onClicked等lambda的声明
         2、返回上一screen等函数的编写
   }*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = AllScreen.valueOf(
        backStackEntry?.destination?.route ?: AllScreen.Main.name
    )

    Scaffold(
        topBar = {
            NewsAppBar(currentScreen = currentScreen)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AllScreen.Main.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = AllScreen.Main.name) {
                MainScreen(

                )
            }
            composable(route = AllScreen.Login.name) {
                LoginScreen(

                )
            }
            composable(route = AllScreen.SignUp.name) {
                SignUpScreen(

                )
            }
            composable(route = AllScreen.Search.name) {
                SearchScreen(

                )
            }
            composable(route = AllScreen.Profile.name) {
                ProfileScreen(

                )
            }
            composable(route = AllScreen.HomePage.name) {
                HomePageScreen(

                )
            }
            composable(route = AllScreen.Article.name) {
                ArticleScreen(

                )
            }
        }
    }
}