package com.example.safe_heaven

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.safe_heaven.navigation.SHRouter
import com.example.safe_heaven.navigation.Screen
import com.example.safe_heaven.screens.LoginScreen
import com.example.safe_heaven.screens.SignupScreen
import com.example.safe_heaven.screens.TAndCScreen

@Composable
fun SafeHeaven(){
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        Crossfade(targetState = SHRouter.currentScreen) {currentState->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignupScreen()
                }
                is Screen.TandCScreen ->{
                    TAndCScreen()
                }
                is Screen.LoginScreen ->{
                    LoginScreen()
                }
            }
        }
    }
}