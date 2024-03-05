package com.example.eateryapp.rules

object Validator {


    fun validateName(Name: String): ValidationResult {
        return ValidationResult(
            (!Name.isNullOrEmpty() && Name.length >= 2)
        )

    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length >= 6)
        )
    }

}

data class ValidationResult(
    val status: Boolean = false
)