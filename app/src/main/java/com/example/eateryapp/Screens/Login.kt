package com.example.eateryapp.Screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.Data.database
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.DelicateCoroutinesApi

class Login {
        companion object{
            @OptIn(DelicateCoroutinesApi::class)
            @SuppressLint("SuspiciousIndentation")
            @Composable
            fun Login(navController: NavController){

                val localContext = LocalContext.current

                Box(
                    modifier = Modifier
                        .fillMaxSize()
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
                ){
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Sign In",
                            fontSize = 60.sp,
                            modifier = Modifier.padding(40.dp),
                            color = Color.Black
                        )
                        Text(
                            text="Enter Your Email And Password",
                            fontSize = 5.em,
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            color = Color.Black
                        )

                        var mailStore by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value =mailStore ,
                            onValueChange ={ mailStore=it},
                            singleLine = true,
                            label = { Text(text = "Email")},
//                            colors = TextFieldDefaults.colors()
                            modifier= Modifier
                                .fillMaxWidth()
                                .padding(bottom = 30.dp),
                            shape = RoundedCornerShape(20.dp)
                        )

                        var passStore by remember {mutableStateOf("") }
                        OutlinedTextField(value = passStore , onValueChange = { passStore=it},
                        singleLine = true,
                        label = { Text(text = "Password")},
//                            colors = TextFieldDefaults.colors()
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp))

                        Row(){
                            CreateLoginButton(mailStore, passStore,navController,localContext,"Login As User","mapClass")
//                            Spacer(modifier = Modifier.width(10.dp))
                            CreateLoginButton(mailStore, passStore,navController,localContext,"Login As Owner","mapClass")

                        }


                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text="Don't have an account?",
                                fontSize = 4.em,
                                modifier = Modifier.padding(20.dp),
                                color = Color.White
                            )
                            Text(
                                text="Sign Up",
                                fontSize = 4.em,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .clickable {
                                        navController.navigate("SignUP")
                                    },
                                color = Color.Blue
                            )

                        }

                    }
                }
            }



            @Composable
            private fun CreateLoginButton(mailStore: String,passStore:String,navController: NavController,localContext:Context,buttonText:String,navigationText:String){
                Button(
                    onClick = {
                        if(passStore.isNotEmpty() and mailStore.isNotEmpty()) {
                            checkLogin(mailStore, passStore,navController,localContext,navigationText)
//                                    GlobalScope.launch {
//                                    val temp = checkLogin(mailStore, passStore)
////                                    Thread.sleep(5000)
//                                    Log.d("login", "temp = $temp")
//
//                                        navController.navigate("MapClass")
//                                    } else {
//
//                                    }
//                                }
                        }
                        else{
                            Toast.makeText(localContext,"Provide email and password",Toast.LENGTH_SHORT).show()
                        }
                    },

                    modifier = Modifier
                        .padding(5.dp)
                        .size(160.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(40.dp)
                ) {
                    Text(
                        text = buttonText,
                        color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                    )
                }
            }


             private fun checkLogin(
                 mailStore: String,
                 passStore: String,
                 navController: NavController,
                 localContext: Context,
                 navigationText:String
             ){
                val reference: DatabaseReference = database.reference.child("SignUP Information")
                reference.addListenerForSingleValueEvent(
                    object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for (snap in snapshot.children) {
                                val mail = snap.key.toString()
                                val pass = snap.child("pass").value.toString()

                                Log.d("login", "Database mail: $mail  Textfield Mail -> $mailStore ||| Database -> $pass Textfield ->  $passStore")

                                if(mail == mailStore && pass == passStore){
                                    Toast.makeText(localContext, "Successfully Signed In", Toast.LENGTH_SHORT).show()
                                    navController.navigate(navigationText)
                                    break
                                }
                            }
                             Toast.makeText(localContext, "Provided Wrong Email and Password", Toast.LENGTH_SHORT).show()
                        }


                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(localContext, "Unable to read from database", Toast.LENGTH_SHORT).show()
//                            Log.d("login","Login Fail")
                        }
                    }
                )
            }
        }
}