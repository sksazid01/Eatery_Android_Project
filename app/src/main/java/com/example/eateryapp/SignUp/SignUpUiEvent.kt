package com.example.eateryapp.SignUp

sealed class SignUpUiEvent{
    data class nameChange(val name: String) : SignUpUiEvent()
    data class emailChange(val email: String) : SignUpUiEvent()
    data class passwordChange(val password: String) : SignUpUiEvent()
    object RegisterButtonClick : SignUpUiEvent()
}