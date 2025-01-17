package com.example.safe_heaven.data.rules

object Validator {
    fun validateFirstName(fName: String): ValidateResult {
        return ValidateResult(
            (!fName.isNullOrEmpty() && fName.length>=6)
        )
    }
    fun validateLastName(sName: String): ValidateResult {
        return ValidateResult(
            (!sName.isNullOrEmpty() && sName.length>=4)
        )
    }
    fun validateEmail(mail: String): ValidateResult {
        return ValidateResult(
            (!mail.isNullOrEmpty())
        )
    }
    fun validatePassword(password: String): ValidateResult {
        return ValidateResult(
            (!password.isNullOrEmpty() && password.length>=6)
        )
    }

}

data class ValidateResult(
    val status: Boolean = false,
)
