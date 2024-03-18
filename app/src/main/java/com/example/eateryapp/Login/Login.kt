package com.example.eateryapp.Login

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.eateryapp.Data.localContext
import com.example.eateryapp.Data.userName
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

                localContext = LocalContext.current

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
                            CreateLoginButton(mailStore, passStore,navController,localContext,"Login As User","mapClass",Color.Red)
//                            Spacer(modifier = Modifier.width(10.dp))
                            CreateLoginButton(mailStore, passStore,navController,localContext,"Login As Owner","Owner",Color(0xFF1e67c7))
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
            private fun CreateLoginButton(mailStore: String,passStore:String,navController: NavController,localContext:Context,buttonText:String,navigationText:String,color:Color){
                Button(
                    onClick = {
                        if(passStore.isNotEmpty() and mailStore.isNotEmpty()) {
                            checkLogin(mailStore, passStore,navController,localContext,navigationText)
                        }
                        else{
                            Toast.makeText(localContext,"Provide email and password",Toast.LENGTH_SHORT).show()
                        }
                    },

                    modifier = Modifier
                        .padding(5.dp)
                        .size(160.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(color),
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
             ){ var flag=true
                val reference: DatabaseReference = database.reference.child("SignUP Information")
                reference.addListenerForSingleValueEvent(
                    object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for (snap in snapshot.children) {
//                                val mail = snap.key.toString() // this is for mail as a root
                                val mail = snap.child("mail").value.toString()
                                val pass = snap.child("pass").value.toString()
                                val name = snap.child("name").value.toString()

                                Log.d("login", "Database mail: $mail  Text-field Mail -> $mailStore ||| Database -> $pass Textfield ->  $passStore UserName = $name")

                                if(mail == mailStore && pass == passStore){
                                    userName = name
                                    // Save the flag for successfully Login.
                                    FlagManager.saveFlag(localContext, 2)

                                    Toast.makeText(localContext, "Successfully Signed In", Toast.LENGTH_SHORT).show()
                                    navController.navigate(navigationText)
                                    flag = false
                                    break
                                }
                            }
                            if(flag) {
//                                passStore=""
                                Toast.makeText(
                                    localContext,
                                    "Provided Wrong Email and Password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
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