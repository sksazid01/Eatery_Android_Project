package com.example.eateryapp.SignUp

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.eateryapp.Data.SingUPData
import com.example.eateryapp.Data.database
import com.example.eateryapp.Data.localContext
import com.example.eateryapp.Data.navController2
import com.example.eateryapp.Data.ok
import com.example.eateryapp.Data.totalUser
import com.example.eateryapp.rules.Validator
import com.google.firebase.auth.FirebaseAuth


class SignUpViewModel: ViewModel() {

    var signUpstate = mutableStateOf(SignUpState())
    var allValidationsPassed = mutableStateOf(false)
    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignUpUiEvent) {
        when (event) {
            is SignUpUiEvent.nameChange -> {
                signUpstate.value = signUpstate.value.copy(
                    name = event.name
                )
            }

            is SignUpUiEvent.emailChange -> {
                signUpstate.value = signUpstate.value.copy(
                    email = event.email
                )
            }


            is SignUpUiEvent.passwordChange -> {
                signUpstate.value = signUpstate.value.copy(
                    password = event.password
                )
            }

            is SignUpUiEvent.RegisterButtonClick -> {
                signUp()
            }
        }
        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val name = Validator.validateName(
            Name = signUpstate.value.name
        )

        val emailResult = Validator.validateEmail(
            email = signUpstate.value.email
        )


        val passwordResult = Validator.validatePassword(
            password = signUpstate.value.password
        )
        allValidationsPassed.value = name.status && emailResult.status && passwordResult.status
    }

    private fun signUp() {
        createUserInFirebase(
            email = signUpstate.value.email,
            password = signUpstate.value.password
        )
    }

    val signUpRef = database.getReference("SignUP Information")
    val totalUserRef = database.getReference("totalUser")

    private fun createUserInFirebase(email: String, password: String) {

        signUpInProgress.value = true

        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                signUpInProgress.value = false
                if (it.isSuccessful) {
//                    navController.navigate("Login")
                    ok = true
                }
            }
            .addOnFailureListener {
                Log.d("fail","SignUp Failed for ${it.message}")
            }
        totalUserRef.setValue(totalUser+1)
        val data= SingUPData(signUpstate.value.name,signUpstate.value.email,signUpstate.value.password)
        signUpRef.child((totalUser+1).toString()).setValue(data)
                                    .addOnSuccessListener {
                                        signUpstate.value.name=""
                                        signUpstate.value.email=""
                                        signUpstate.value.password=""
                                        navController2.navigate("Login")

                                        Toast.makeText(localContext,"Account has been successfully created",Toast.LENGTH_SHORT).show()

                                    }.addOnFailureListener {
                                        Log.d("signup","onClick button pressed and Unsuccessfully and totalUser: $totalUser")
//                                        Toast.makeText(toastContext,it.toString(),Toast.LENGTH_SHORT).show()
                                    }
    }

}