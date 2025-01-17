package com.example.safe_heaven.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val TAG =LoginViewModel::class.simpleName
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvents) {
        when (event) {
            is UIEvents.FirstNameChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
            }

            is UIEvents.LastNameChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lasName = event.lastName
                )
            }

            is UIEvents.EmailChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
            }

            is UIEvents.PasswordChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
            }
            is UIEvents.RegisterButtonClicked ->{
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG,"inside signup func")
        printState()
    }

    private fun printState(){
        Log.d(TAG,"Inside printState")
        Log.d(TAG,registrationUIState.value.toString())
    }
}