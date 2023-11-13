package com.example.jetpack.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailStory : Screen("home/{storyId}") {
        fun createRoute(storyId: Long) = "home/$storyId"
    }
}
