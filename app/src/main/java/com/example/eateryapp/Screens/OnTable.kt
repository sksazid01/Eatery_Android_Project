package com.example.eateryapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.eateryapp.Data.resName
import com.example.eateryapp.Data.selectedResID

@Composable
fun OnTableOrder(navController: NavController){
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
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Text(text = "Your Have Successfully Confirm\n                 Your Order")
            Spacer(modifier = Modifier.height(100.dp))

            Button(
                onClick = {
                    for(itt in resName[selectedResID].itemsWhen.indices)
                        for(it in resName[selectedResID].itemsWhen[itt].items.indices) {
                            resName[selectedResID].itemsWhen[itt].items[it].numberOfSelection = 0
                            resName[selectedResID].itemsWhen[itt].items[it].isSelected = false
                        }

                    navController.navigate("RestaurantClass")
                },
                modifier= Modifier
                    .width(160.dp)
                    .padding(5.dp)
                    .height(50.dp),
//                                .background(Color(0xFF644AB5)), wrong approach
                colors = ButtonDefaults.buttonColors(Color(0xFF644AB5)),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = "Back",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 4.em
                )
        }
    }
}}