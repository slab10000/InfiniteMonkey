package com.slab11.infinitemonkey.presentation

sealed class Screen (val route: String){
    object  MainScreen: Screen("main_screen")
}
