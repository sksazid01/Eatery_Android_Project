package com.example.eateryapp.SignUp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eateryapp.Data.localContext
import com.example.eateryapp.Data.navController

@Composable
fun subscriptionUI(){
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
                text = "To continue,\nyou need to subscribe.",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp),
                color = Color.Black
            )

            Column{
                Button(
                    onClick = {
                        subscriptionOn()
                    },

                    modifier = Modifier
                        .padding(5.dp)
                        .size(300.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    shape = RoundedCornerShape(50.dp)

                ) {
                    Text(
                        text = "Subscribe",
                        color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                    )
                }

                Button(
                    onClick = {
                        subscriptionOff()
                    },

                    modifier = Modifier
                        .padding(5.dp)
                        .size(300.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(50.dp)

                ) {
                    Text(
                        text = "UnSubscribe",
                        color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}