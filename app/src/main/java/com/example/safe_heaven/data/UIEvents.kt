package com.example.safe_heaven.data

sealed class UIEvents {
    data class FirstNameChanges(val firstName: String) : UIEvents()
    data class LastNameChanges(val lastName: String) : UIEvents()
    data class EmailChanges(val email: String) : UIEvents()
    data class PasswordChanges(val password: String) : UIEvents()

    object RegisterButtonClicked :UIEvents()
}