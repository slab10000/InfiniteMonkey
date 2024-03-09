package com.slab11.infinitemonkey.presentation.landingscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LandingScreen(
    //navController: NavController, //TODO remove?
    viewModel: LandingScreenViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coroutineScope = rememberCoroutineScope()
        var result by remember {mutableStateOf("")}
        var completeText by remember {mutableStateOf("")}

        var action: (result:String, completeText:String) -> Unit = {r: String, c:String ->
            result = r
            completeText = c
        }


        var inputText by remember {mutableStateOf("Texto a buscar")}

        TextField(value = inputText, onValueChange = {value: String -> inputText = value })
        Spacer(modifier = Modifier.size(10.dp))

        Row (
            modifier = Modifier
                .padding(10.dp)
        ){

            Text(text = result)

            /*letterPlaceholder()
            Spacer(modifier = Modifier.size(10.dp))
            letterPlaceholder()
            Spacer(modifier = Modifier.size(10.dp))
            letterPlaceholder()*/
        }
        Button(
            onClick = { viewModel.onButtonClick(action) },
        )
        {
            Text(text = "Generar")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            println(completeText)
            Text(
                modifier = Modifier.fillMaxSize(),
                text = completeText
            )
        }

    }

}

@Composable
fun letterPlaceholder(
    modifier: Modifier = Modifier
){
  Row(
      modifier = modifier
          .size(letterPlaceholderSize.dp)
          .border(width = letterPlaceholderBorderSize.dp, color = Color.Black)
  ){}
}

fun getRandomString(length: Int) : String {
    val charset = ('a'..'z') /*+ ('A'..'Z') + ('0'..'9')*/
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

private const val letterPlaceholderSize = 30
private const val letterPlaceholderBorderSize = 2
