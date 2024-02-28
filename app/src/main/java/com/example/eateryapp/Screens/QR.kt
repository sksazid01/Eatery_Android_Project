package com.example.eateryapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.eateryapp.R

class QR {
    companion object{
        @Composable
        fun Qr(navController: NavController){

            val configuration = LocalConfiguration.current
            val screenWidthDp = configuration.screenWidthDp.dp
            val screenHeightDp = configuration.screenHeightDp.dp

            Column {
//                BottomNavigationBar.BottomNavigationBar()
                Box(
//                        contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(screenWidthDp)
                        .height(screenHeightDp-100.dp)
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
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Scan QR Code",
                            color = Color.Red,
                            fontSize = 10.em,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding()
                        )
                        Text(
                            text = "To Select Table Number",
                            fontWeight = FontWeight.Bold,
                            fontSize = 4.em
                        )
                        Text(
                            text = "and Find Menu",
                            fontWeight = FontWeight.Bold,
                            fontSize = 4.em

                        )
                        Spacer(modifier = Modifier.height(60.dp))
                        Image(
                            painter = painterResource(id = R.drawable.qrcodelogo),
                            contentDescription = "",
                            modifier = Modifier.size(250.dp)
                        )


                        Spacer(modifier = Modifier.height(60.dp))

                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .padding(30.dp)
                                .size(300.dp, 50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red),
                            shape = RoundedCornerShape(50.dp)

                        ) {
                            Text(
                                text = "Turn On Camera",
                                color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                }
            }
    }}
}