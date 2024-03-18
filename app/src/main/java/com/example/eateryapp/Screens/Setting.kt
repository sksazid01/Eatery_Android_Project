package com.example.eateryapp.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.Data.UserMail
import com.example.eateryapp.Data.localContext
import com.example.eateryapp.Data.userName
import com.example.eateryapp.Login.FlagManager
import com.example.eateryapp.Login.Login

@Composable
fun SettingUI(navController: NavController){
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
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "UserName",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = userName,
                fontSize = 20.sp
            )
            Text(
                text = "Email",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = UserMail,
                fontSize = 20.sp
            )



            Spacer(modifier = Modifier.height(200.dp))


            OutlinedButton(
                onClick = {

                },

                modifier = Modifier
                    .padding(5.dp)
                    .size(250.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),

//                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "Change User Information",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }




            OutlinedButton(
                onClick = {

                },

                modifier = Modifier
                    .padding(5.dp)
                    .size(180.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),

//                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "Help Center",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            OutlinedButton(
                onClick = {

                },

                modifier = Modifier
                    .padding(5.dp)
                    .size(170.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),

                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "Dark Mode",
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Button(
                onClick = {
                    Toast.makeText(localContext,"Successfully Logged Out",Toast.LENGTH_SHORT).show()
                    FlagManager.saveFlag(localContext, 1)
                    navController.navigate("Login")
                },

                modifier = Modifier
                    .padding(5.dp)
                    .size(160.dp, 35.dp)
                    .align(Alignment.CenterHorizontally),

                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "LogOut",
                    color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}