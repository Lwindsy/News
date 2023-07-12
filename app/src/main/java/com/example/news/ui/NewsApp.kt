package com.example.news.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.news.R
import com.example.news.ui.screens.ArticleScreen
import com.example.news.ui.screens.CommentScreen
import com.example.news.ui.screens.HomePageScreen
import com.example.news.ui.screens.LoginScreen
import com.example.news.ui.screens.MainScreen
import com.example.news.ui.screens.ProfileScreen
import com.example.news.ui.screens.SearchScreen
import com.example.news.ui.screens.SignUpScreen
import com.example.news.ui.theme.Head_ArticleBar
import com.example.news.ui.theme.Head_SearchBar
import com.example.news.ui.theme.Head_SignupBar
import com.example.news.ui.utils.HomepageBottomBar
import com.example.news.ui.utils.ProfileBottomBar
import com.example.news.ui.viewmodel.BOOKMARKED_TABLE
import com.example.news.ui.viewmodel.BOTTOM_TABLE
import com.example.news.ui.viewmodel.HEAD_TABLE
import com.example.news.ui.viewmodel.NewsAppViewModel
import com.example.news.ui.viewmodel.SEARCH_TABLE
import com.example.news.ui.viewmodel.SignUpInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// for navigation
enum class AllScreen(@StringRes val title: Int) {
    Article(title = R.string.Article),
    HomePage(title = R.string.Homepage),
    Login(title = R.string.Login),
    Main(title = R.string.Main),
    Profile(title = R.string.Profile),
    Search(title = R.string.Search),
    SignUp(title = R.string.Signup),
    Comment(title = R.string.comment)
}

//HeadBar存在于
@Composable
fun NewsAppHeadBar(
    modifier: Modifier = Modifier,
    currentScreen: AllScreen,
    onReturnClicked: () -> Unit = {},
    onSearchClick:(String) -> Unit = {}
) {
    when (currentScreen.title) {
        R.string.Article -> {
            Head_ArticleBar(
                onReturnClicked = {
                    onReturnClicked()
                }
            )
        }

        R.string.Homepage -> {
            Head_SearchBar(onSearchClick = onSearchClick)
        }

        R.string.comment -> {
            Head_ArticleBar(
                onReturnClicked = {
                    onReturnClicked()
                }
            )
        }

        else -> {

        }
    }

}

@Composable
fun NewsAppBottomBar(
    modifier: Modifier = Modifier,
    currentScreen: AllScreen,
    onProfileClick: () -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    when (currentScreen.title) {
        R.string.Article -> {
//            ArticleScreenBar(value = value, onValueChange = onValueChange)
        }

        R.string.Homepage -> {
            HomepageBottomBar(
                onProfileClick = {
                    onProfileClick()
                },
                onHomeClick = {
                    onHomeClick()
                }
            )
        }

        R.string.Login -> {
            // 不需要
        }

        R.string.Main -> {
            // 不需要
        }

        R.string.Profile -> {
            ProfileBottomBar(
                onProfileClick = {
                    onProfileClick()
                },
                onHomeClick = {
                    onHomeClick()
                }
            )
        }

        R.string.Search -> {
            // 不需要
        }

        R.string.Signup -> {
            // 不需要
        }

        R.string.comment -> {

        }
    }
}

fun composable(route: Any, function: () -> Unit) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: NewsAppViewModel = viewModel()
) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = AllScreen.valueOf(
        backStackEntry?.destination?.route ?: AllScreen.Main.name
    )

    val userState by viewModel.userUiState.collectAsState()
    val articleItem by viewModel.articleUiState.collectAsState()
    Scaffold(
        topBar = {
            NewsAppHeadBar(currentScreen = currentScreen,
                onReturnClicked = {
                    navController.popBackStack()
                },
                onSearchClick = {
                    viewModel.getArticleTable(tableType = SEARCH_TABLE, searchText = it)
                    navController.navigate(AllScreen.Search.name)
                }
            )
        },
        bottomBar = {
            NewsAppBottomBar(currentScreen = currentScreen,
                onHomeClick = {
                    navController.navigate(AllScreen.HomePage.name)
                },
                onProfileClick = {
                    navController.navigate(AllScreen.Profile.name)
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AllScreen.Main.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = AllScreen.Comment.name){
                CommentScreen(commentList = articleItem.commentList)
            }
            composable(route = AllScreen.Main.name) {
                MainScreen(
                    onSignUpButtonClicked = {
                        navController.navigate(AllScreen.SignUp.name)
                    },
                    onLogInButtonClicked = {
                        navController.navigate(AllScreen.Login.name)
                    }
                )
            }
            composable(route = AllScreen.Login.name) {
                LoginScreen(
                    onSignUpButtonClicked = {
                        navController.navigate(AllScreen.SignUp.name)
                    },
                    onLogInSuccess = {
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = HEAD_TABLE,
                                articleType = "worldnews"
                            )
                        }
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = BOTTOM_TABLE,
                                articleType = "onhit"
                            )
                        }
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = BOTTOM_TABLE,
                                articleType = "exam"
                            )
                        }
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = BOTTOM_TABLE,
                                articleType = "award"
                            )
                        }
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = BOTTOM_TABLE,
                                articleType = "activity"
                            )
                        }
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = BOTTOM_TABLE,
                                articleType = "notification"
                            )
                        }
                        /* querying User's bookmark would only start when user successfully log in.So probably the ProfileLoadingCard is not necessary,
                        * unless we start the query while entering profile.
                        */
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(
                                tableType = BOOKMARKED_TABLE,
                                userId = userState.userId.toLong()
                            )
                        }
                        viewModel.viewModelScope.launch {
                            viewModel.getUserInfo(userId = userState.userId.toLong())
                        }
                        navController.navigate(AllScreen.HomePage.name)
                        viewModel.viewModelScope.launch{
                            delay(1000)
                            viewModel.setSuccessFalse()
                        }

                    },
                    onLogInButtonClicked = {
                        viewModel.cmpUserInfo(it)
                    },
                    newsAppViewModel = viewModel
                )
            }
            composable(route = AllScreen.SignUp.name) {
                SignUpScreen(
                    onSignUpButtonClicked = {
                        viewModel.commitSignUpInfo(it)
                    },
                    onLogInButtonClicked = {
                        viewModel.setAllSignUpInfoFalse()
                        navController.navigate(AllScreen.Login.name)
                    },
                    onSignUpSuccess = {
                        viewModel.viewModelScope.launch {
                            viewModel.setDisplayMsg(SignUpInfo.SIGNUP_SUCCESS,true)
                            delay(1500)
                            navController.navigate(AllScreen.Login.name)
                            viewModel.setAllSignUpInfoFalse()
                        }
                    },
                    onReturnClicked = {
                        viewModel.setAllSignUpInfoFalse()
                        navController.navigate(AllScreen.Login.name)
                    },
                    viewModel = viewModel
                )
            }
            composable(route = AllScreen.Search.name) {
                SearchScreen(
                    viewModel = viewModel,
                    onArticleCardClick = {
                        viewModel.viewModelScope.launch {
                            viewModel.getArticle(it.toLong())
                        }
                        navController.navigate(AllScreen.Article.name)
                    },
                    onReturnClicked = {
                        navController.navigate(AllScreen.HomePage.name)
                    }
                )
            }
            composable(route = AllScreen.Profile.name) {
                ProfileScreen(
                    viewModel = viewModel,
                    onArticleCardClick = {
                        viewModel.viewModelScope.launch {
                            viewModel.getArticle(it.toLong())
                        }
                        navController.navigate(AllScreen.Article.name)
                    }
                )
            }
            composable(route = AllScreen.HomePage.name) {
                HomePageScreen(
                    viewModel = viewModel,
                    onArticleCardClick = {
                        viewModel.viewModelScope.launch {
                            viewModel.getArticle(it.toLong())
                        }
                        navController.navigate(AllScreen.Article.name)
                    },
                    onTypeClick = {
                        viewModel.viewModelScope.launch {
                            viewModel.getArticleTable(tableType = BOTTOM_TABLE, articleType = it)
                        }
                    }
                )
            }
            composable(route = AllScreen.Article.name) {
                ArticleScreen(
                    viewModel = viewModel,
                    onCommentClick = {
                        navController.navigate(AllScreen.Comment.name)
                    }
                )
            }
        }
    }
}