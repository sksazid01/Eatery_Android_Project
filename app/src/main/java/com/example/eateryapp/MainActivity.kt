package com.example.eateryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eateryapp.Data.LoadFromMain
import com.example.eateryapp.Screens.Class02
import com.example.eateryapp.Screens.Class03
import com.example.eateryapp.Screens.Class04
import com.example.eateryapp.Screens.MapClass
import com.example.eateryapp.ui.theme.EateryAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EateryAppTheme {
                LoadFromMain()
//                RestaurantList(resName);

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "RestaurantClass") {
                composable("Main") { FirstScreen(navController)}
                composable("Class02") { Class02.View02(navController)}
                composable("Class03"){ Class03.View03(navController)}
                composable("Class04"){ Class04.View04(navController)}
                composable("MapClass"){ MapClass.View05(navController)}
                composable("RestaurantClass"){BottomNavigationBar.BottomNavigationBar()}
              }
            }
        }
    }


    @Composable
    fun FirstScreen(navC:NavController){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Transparent
        ) {
            Box(
//                        contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF3AFF70),
                                Color(0xFFFDE406),
                                Color(0xFFFC0000)
                            ),
                            start = Offset.Zero,
                            end = Offset.Infinite,
                            tileMode = TileMode.Decal
                        )
                    )
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center

                ){
                    Spacer(modifier = Modifier.height(14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.home1),
                        contentDescription = "",
                        modifier = Modifier
                            .size(500.dp)
                            .padding(50.dp)
                    )
//                            Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "Welcome To",
                        fontSize = 40.sp,
                        color = Color.White,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center

                    )
                    Text(
                        text = "Eatery",
//                                modifier = Modifier.size(300.dp),
                        fontSize = 60.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
        LaunchedEffect(Unit) {
            delay(2000) // Simulating a 2-second delay
            navC.navigate("Class02")
        }
    }
}
