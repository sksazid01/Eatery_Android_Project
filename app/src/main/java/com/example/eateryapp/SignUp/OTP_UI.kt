package com.example.eateryapp.SignUp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.eateryapp.Data.localContext

class OTP_UI {
    companion object {
        @Composable
        fun OtpVerification(navController: NavController) {
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
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Verification",
                        fontSize = 50.sp,
                        modifier = Modifier.padding(20.dp),
                        color = Color.Black
                    )
                    var otpStore by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = otpStore,
                        onValueChange = { otpStore = it },
                        singleLine = true,
                        label = { Text(text = "Inter Your OTP here") },
//                            colors = TextFieldDefaults.colors()
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp)
                    )

                    Button(
                        onClick = {
                            checkOTP(otpStore,navController)
                        },

                        modifier = Modifier
                            .padding(5.dp)
                            .size(300.dp, 50.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(50.dp)

                    ) {
                        Text(
                            text = "Continue",
                            color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}