package com.slab11.infinitemonkey.presentation.landingscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun LandingScreen(
    //navController: NavController, //TODO remove?
    viewModel: LandingScreenViewModel = hiltViewModel()
){
    Column() {
        Text(text = "Hola")
    }

}