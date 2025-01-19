package com.example.safe_heaven.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.safe_heaven.data.rules.Validator

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvents) {
        validateDataWithRules()
        when (event) {
            is UIEvents.FirstNameChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is UIEvents.LastNameChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lasName = event.lastName
                )
                printState()
            }

            is UIEvents.EmailChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is UIEvents.PasswordChanges -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is UIEvents.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "inside signup func")
        printState()
        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )

        val sNameResult = Validator.validateLastName(
            sName = registrationUIState.value.lasName
        )
        val emailResult = Validator.validateEmail(
            mail = registrationUIState.value.email
        )
        val pwdResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )
        Log.d(TAG, "FName =$fNameResult")
        Log.d(TAG, "LName= $sNameResult")
        Log.d(TAG, "Email = $emailResult")
        Log.d(TAG, "Password = $pwdResult")

        registrationUIState.value = registrationUIState.value.copy(
            fNameError = fNameResult.status,
            lasNameError = sNameResult.status,
            emailError = emailResult.status,
            passwordError = pwdResult.status
        )
    }

    private fun printState() {
        Log.d(TAG, "Inside printState")
        Log.d(TAG, registrationUIState.value.toString())
    }
}