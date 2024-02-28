package com.example.eateryapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.R

class Class04 {
    companion object{

        @Composable
        fun View04(navController: NavController){
            Box(
//              contentAlignment = Alignment.Center,
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
//                Row (
//                    modifier = Modifier.height(60.dp).fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End
//                ){
//                    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
//                        Text(
//                            text = "Skip > ",
//                            color = Color.Red,
//                        )
//
//                    }
//                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center

                ){
//                        Spacer(modifier = Modifier.height(14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img4),
                        contentDescription = "",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(50.dp)
                    )
                    Text(
                        text = "Choose favorite dishes!",
                        fontSize = 22.sp,
                        color = Color.Red,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center

                    )
                    Text(
                        text = "In publishing and graphic design, Lorem ipsum is a\nplaceholder text commonly used to demonstrate the\n visual form of a document",
//                                modifier = Modifier.size(300.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    modifier= Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                        Spacer(modifier = Modifier.height(250.dp))
                    Button(
                        onClick = {
                                  navController.navigate("MapClass")
                                  },
                        modifier = Modifier
                            .padding(30.dp)
                            .size(300.dp, 50.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(50.dp)

                    ) {
                        Text(
                            text = "GET STARTED",
                            color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }}}
}