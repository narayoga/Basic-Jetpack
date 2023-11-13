package com.example.jetpack

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dicoding.jetreward.ui.screen.profile.ProfileScreen
import com.example.jetpack.ui.navigation.NavigationItem
import com.example.jetpack.ui.navigation.Screen
import com.example.jetpack.ui.screen.Detail.DetailScreen
import com.example.jetpack.ui.screen.home.HomeScreen
import com.example.jetpack.ui.theme.JetpackTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetpackApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailStory.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
//                println("Clicked, currentRoute: $currentRoute, expectedRoute: home")
                HomeScreen(
                    navigateToDetail = {
                        storyId -> navController.navigate(Screen.DetailStory.createRoute(storyId))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailStory.route,
                arguments = listOf(navArgument("storyId") {type = NavType.LongType})
            ){
                val id = it.arguments?.getLong("storyId") ?: -1L
                println("${id}, masuk detailScreen")
                DetailScreen(
                    storyId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },

                )
            }
        }


    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = "home",
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "profile",
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
//                selected = false,
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetpackPreview() {
    JetpackTheme {
        JetpackApp()
    }
}
