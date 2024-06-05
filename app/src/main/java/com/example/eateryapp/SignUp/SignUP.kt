package com.example.eateryapp.SignUp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.eateryapp.Data.SingUPData
import com.example.eateryapp.Data.database
import com.example.eateryapp.Data.loadTotalUser
import com.example.eateryapp.Data.passWord
import com.example.eateryapp.Data.phoneNumber
import com.example.eateryapp.Data.totalUser
import com.example.eateryapp.R

class SignUP {
    companion object{
        @Composable
        fun SignUP(
            navController: NavController,
            signUpViewModel: SignUpViewModel = viewModel()
           ){

            val configuration = LocalConfiguration.current
            val screenWidthDp = configuration.screenWidthDp.dp
            val screenHeightDp = configuration.screenHeightDp.dp

            val scrollState = rememberScrollState()

            Box(
                modifier = Modifier
                    .width(screenWidthDp)
                    .height(screenHeightDp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFF5E667),
                                Color(0xFFED8888)
                            ),
                            start = Offset.Zero,
                            end = Offset.Infinite,
                            tileMode = TileMode.Decal
                        )
                    )
                    .verticalScroll(scrollState)
            ){
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 15.em,
                        modifier = Modifier.padding(40.dp),
                        color = Color.Black
                    )
                    Text(
                        text="Enter Your Information",
                        fontSize = 4.em,
                        modifier = Modifier.padding(20.dp),
                        color = Color.Black
                    )

                    var nameStore by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value =nameStore ,
                        onValueChange ={ nameStore=it},
                        singleLine = true,
                        label = { Text(text = "User Name")},
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp)
                    )
//                    MyTextFieldComponent(
//                        labelValue = "Name...",
//                        onTextChanged = {
//                            signUpViewModel.onEvent(SignUpUiEvent.nameChange(it))
//                        },
//                    )

                    var mailStore by remember { mutableStateOf("88") }
                    OutlinedTextField(
                        value =mailStore ,
                        onValueChange ={ mailStore=it},
                        singleLine = true,
                        label = { Text(text = "Phone Number")},
//                            colors = TextFieldDefaults.colors()
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp)
                    )
//
//                    MyTextFieldComponent(
//                        labelValue = "Email...",
//                        onTextChanged = {
//                            signUpViewModel.onEvent(SignUpUiEvent.emailChange(it))
//                        },
//                    )

                    var passStore by remember {mutableStateOf("") }
                    var passwordVisibility by remember {mutableStateOf(false) }


                    OutlinedTextField(value = passStore , onValueChange = { passStore=it},
                        singleLine = true,
                        label = { Text(text = "Password")},
//                            colors = TextFieldDefaults.colors()
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = if (passwordVisibility) R.drawable.eyeopen else R.drawable.hide),
                                contentDescription = if (passwordVisibility) "Hide Password" else "Show Password",
                                modifier = Modifier.clickable { passwordVisibility = !passwordVisibility }
                            )
                        }
                        )

//                    PasswordTextFieldComponent(
//                        labelValue = "Password...",
//                        onTextSelected = {
//                            signUpViewModel.onEvent(SignUpUiEvent.passwordChange(it))
//                        },
//                    )

///////////////////////////////////////////////// Write a message to the database //////////////////////////////////////////////////////////////////


                    val signUpRef = database.getReference("SignUP Information")
                    val totalUserRef = database.getReference("totalUser")
                    val toastContext = LocalContext.current

                    Button(
                        onClick = {
//                                Log.d("signup","onClick button pressed")
                                if(nameStore.isNotEmpty() and passStore.isNotEmpty() and mailStore.isNotEmpty()){
                                    loadTotalUser()
//                                    Log.d("signup","onClick button pressed and strings are not empty and totalUser: $totalUser")
//                                    increase total user and provide unique id for every user.
                                     totalUserRef.setValue(totalUser+1)

                                      passWord = passStore
                                      phoneNumber = mailStore

//                                    sendOTP()
//                                    navController.navigate("OTP")
                                      navController.navigate("Subscription")


//                                    val data= SingUPData(nameStore,mailStore,passStore)
//
//                                    signUpRef.child(totalUser.toString()).setValue(data)
//                                    .addOnSuccessListener {
//                                        nameStore=""
//                                        mailStore=""
//                                        passStore=""
//                                        navController.navigate("OTP")
//                                    Toast.makeText(toastContext,"Account has been successfully created",Toast.LENGTH_SHORT).show()
//
//                                    }.addOnFailureListener {
////                                        Log.d("signup","onClick button pressed and Unsuccessfully and totalUser: $totalUser")
//                                        Toast.makeText(toastContext,it.toString(),Toast.LENGTH_SHORT).show()
//                                    }

                                }
                            else {
                                Toast.makeText(toastContext,"Please Provide All the Information",Toast.LENGTH_SHORT).show()
                            }
                        },


                        modifier = Modifier
                            .padding(5.dp)
                            .size(300.dp, 50.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(50.dp)

                    ) {
                        Text(
                            text = "SignUp As User",
                            color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                        )
                    }

//                    ButtonComponent(
//                        value = "Register",
//                        onButtonClicked = {
//                            signUpViewModel.onEvent(SignUpUiEvent.RegisterButtonClick)
//                        },
//                        isEnabled = signUpViewModel.allValidationsPassed.value
//                    )

                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text="Already have an account,",
                            fontSize = 4.em,
                            modifier = Modifier.padding(20.dp),
                            color = Color.White
                        )
                        Text(
                            text="Login",
                            fontSize = 4.em,
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable {
                                    navController.navigate("Login")
                                },
                            color = Color.Blue
                        )

                    }

                }
            }
        }}}