package com.example.eateryapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.R

class MapClass {
    companion object{
        @Composable
        fun View05(navController: NavController){
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
//                        .fillMaxSize()
                        .padding(15.dp)
                ) {
//                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.map), contentDescription ="",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp), // Must be needed to use free space
//                            .scale(1f),
                        alignment = Alignment.TopCenter,

                    )
                    Text(
                        text = "Add new address",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
//                        textAlign = TextAlign.End
                    )

                    Spacer(modifier = Modifier.weight(0.2f))

                    var title by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = title, onValueChange = { newText -> title = newText },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        label= { Text("Title") },
                        )

                    Spacer(modifier = Modifier.weight(0.2f))

                    var address by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = address, onValueChange = { newText -> address = newText },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        label= { Text("New Address") },
                    )
                    Spacer(modifier = Modifier.weight(0.2f))

                    Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                        RadioButton(selected = true, onClick = { /*TODO*/ })
                        Text("Use current location", fontWeight = FontWeight.ExtraBold)
                    }
                    Button(
                        onClick = {
                                  navController.navigate("RestaurantClass")
                                  },
                        modifier = Modifier
                            .padding(30.dp)
                            .size(300.dp, 50.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(50.dp)

                    ) {
                        Text(
                            text = "SAVE",
                            color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}