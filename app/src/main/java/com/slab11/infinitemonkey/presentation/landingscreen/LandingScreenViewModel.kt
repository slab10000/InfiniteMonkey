package com.slab11.infinitemonkey.presentation.landingscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LandingScreenViewModel @Inject constructor(
    //private val getUseCase: Usecase
): ViewModel(){
    val algo = 1

    fun onButtonClick(
        action: (result:String, completeText:String) -> Unit
    )
    {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var tInicio = System.currentTimeMillis()
                var completeText = ""
                var currentLetter = ""

                for (i in 1..450000) {
                    currentLetter = getRandomString(1)
                    println("$i + $currentLetter")
                    completeText += currentLetter
                }
                var tFinal = System.currentTimeMillis()
                var tDiferencia = (tFinal - tInicio)
                action(tDiferencia.toString(), completeText)
            }
    }

    }
}