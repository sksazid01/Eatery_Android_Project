package com.example.eateryapp.Screens

import android.annotation.SuppressLint
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.eateryapp.Data.RestaurantItems
import com.example.eateryapp.Data.RestaurantName
import com.example.eateryapp.Data.currentUserId
import com.example.eateryapp.Data.database
import com.example.eateryapp.Data.itm
import com.example.eateryapp.Data.resName
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class Login {
        companion object{

            var check = mutableStateOf(0)

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
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Sign In",
                            fontSize = 60.sp,
                            modifier = Modifier.padding(40.dp),
                            color = Color.White
                        )
                        Text(
                            text="Enter Your Email And Password",
                            fontSize = 5.em,
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            color = Color.White
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

                        Button(



                            onClick = {
                                if(passStore.isNotEmpty() and mailStore.isNotEmpty()) {
//                                    check.value = 0// initialization
                                    checkLogin(mailStore, passStore)
                                }
                                else{
                                    Toast.makeText(localContext,"Provide email and password",Toast.LENGTH_SHORT).show()
                                }
                            },

                            modifier = Modifier
                                .padding(30.dp)
                                .size(300.dp, 50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red),
                            shape = RoundedCornerShape(50.dp)

                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                            )
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



            private fun checkLogin(mailStore:String, passStore:String){
                val reference: DatabaseReference = database.reference.child("SignUP Information")
                var count = 0
                reference.addListenerForSingleValueEvent(
                    object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for (snap in snapshot.children) {
                                count += 1
                                val mail = snap.child("mail").value.toString()
                                val pass = snap.child("pass").value.toString()

                                Log.d("login", "$mail <-$mailStore | $passStore-> $pass")

                                if(mail == mailStore && pass == passStore){
//                                    Log.d("login","flag = true")
                                    Log.d("login","Count = $count")
                                    check.value=count
                                    Log.d("login","check.value = ${check.value}")
                                    break
                                }
                            }
                        }


                        override fun onCancelled(error: DatabaseError) {
                            Log.d("login","Login Fail")
                        }
                    }
                )
            }
        }
}