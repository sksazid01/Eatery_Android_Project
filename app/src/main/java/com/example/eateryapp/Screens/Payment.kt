package com.example.eateryapp.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.eateryapp.Data.localContext

@Composable
fun PaymentUI(navController: NavController) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp

    Box(
//                        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(screenWidthDp)
            .height(screenHeightDp - 70.dp)
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
//                        .verticalScroll(scrollState)
    ){
       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .fillMaxSize()
               .padding(10.dp)
       ) {
           Text(text = "     Please Provide your \npayment first to PreOrder")
           OutlinedButton(onClick = {
               Toast.makeText(localContext,"This feature is currently unavailable", Toast.LENGTH_SHORT).show()
           },
               modifier = Modifier.padding(15.dp)
           ) {
               Text(text = "Nagad",
                   fontSize = 20.sp,
               )
           }
           OutlinedButton(onClick = {
               Toast.makeText(localContext,"This feature is currently unavailable", Toast.LENGTH_SHORT).show()
           },
               modifier = Modifier.padding(15.dp)
           ) {
               Text(text = "Rocket",
                   fontSize = 20.sp,
               )
           }
           OutlinedButton(onClick = {
               Toast.makeText(localContext,"This feature is currently unavailable", Toast.LENGTH_SHORT).show()
           },
               modifier = Modifier.padding(15.dp)
           ) {
               Text(text = "Bkash",
                   fontSize = 20.sp,
               )
           }

           OutlinedButton(onClick = {
               Toast.makeText(localContext,"This feature is currently unavailable", Toast.LENGTH_SHORT).show()
           },
               modifier = Modifier.padding(15.dp)
           ) {
               Text(text = "Bank",
                   fontSize = 20.sp,
               )
           }
       }
    }
}