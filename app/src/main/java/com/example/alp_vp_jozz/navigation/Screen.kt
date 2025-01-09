package com.example.alp_vp_jozz.navigation

sealed class Screen(val route: String) {
    object Tournament : Screen("tournament")
}