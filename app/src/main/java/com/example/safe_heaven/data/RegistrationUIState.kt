package com.example.safe_heaven.data

import java.lang.Error

data class RegistrationUIState(
    var firstName: String = "",
    var lasName: String = "",
    var email: String = "",
    var password: String = "",

    var fNameError: Boolean = false,
    var lasNameError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
)