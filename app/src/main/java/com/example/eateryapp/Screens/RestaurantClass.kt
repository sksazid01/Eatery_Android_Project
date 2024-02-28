package com.example.eateryapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.Data.resName
import com.example.eateryapp.Data.selectedResID
import com.example.eateryapp.R

class RestaurantClass {
    companion object{
        @Composable
        fun View06(navController: NavController){

            val configuration = LocalConfiguration.current
            val screenWidthDp = configuration.screenWidthDp.dp
            val screenHeightDp = configuration.screenHeightDp.dp

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
            ){
               Column {
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(10.dp)
                           .height(50.dp),
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Image(
                           painter = painterResource(id = R.drawable.resturant),
                           contentDescription = "",
                           modifier = Modifier.size(40.dp)
                       )
                       Spacer(modifier = Modifier.weight(1f))
                       Text(
                           text = "Restaurants",
                           fontSize = 30.sp,
                           fontWeight = FontWeight.ExtraBold
                       )
                       Spacer(modifier = Modifier.weight(1f))
                       Image(
                           painter = painterResource(id = R.drawable.qr), contentDescription = "",
                           modifier = Modifier
                               .clickable {
                                   navController.navigate("QR")
                               }
                               .size(40.dp)
                       )
                   }
                   Spacer(modifier = Modifier.height(35.dp))

                   var address by remember { mutableStateOf("") }

                   Row (
                       modifier = Modifier.background(Color.Transparent)
                   ){
                       Spacer(modifier = Modifier.weight(1f))
                       OutlinedTextField(
                           value = address, onValueChange = { newText -> address = newText },
                           shape = RoundedCornerShape(15.dp),
                           modifier = Modifier
                               .width(350.dp)
                               .height(70.dp),
                           singleLine = true,
                           label = {
                               Row {
                                   Icon(imageVector = Icons.Default.Search, contentDescription = "")
                                   Spacer(modifier = Modifier.width(25.dp))
                                   Text(
                                       "Search Restaurant...",
                                       color = Color.Gray,
                                       textAlign = TextAlign.Center
                                   )
                               }
                           },
//                       colors = TextFieldDefaults.colors()
                       )
                       Spacer(modifier = Modifier.weight(1f))
                   }
                   Spacer(modifier = Modifier.height(35.dp))


//                   val resList:List<Pair<String,Boolean>> = listOf(
//                       "Central Cafeteria,SUST" to true,
//                       "Shah Poran Hall,Canteen" to true,
//                       "MR Kacchi Ghor,SUST Gate" to false,
//                       "QBistro,SUST Gate" to false,
//                       "Central Cafeteria,SUST" to true,
//                       "Shah Poran Hall,Canteen" to true,
//                       "MR Kacchi Ghor,SUST Gate" to false,
//                       "Central Cafeteria,SUST" to true,
//                       "Shah Poran Hall,Canteen" to true,
//                       "MR Kacchi Ghor,SUST Gate" to false
//                   )

                   LazyColumn(content ={
                       itemsIndexed(resName){
                           index,item->
                           RestaurantCard(item.name,item.status,navController,index)
                       }
                   } )
                   
               }
            }
        }



@Composable
fun RestaurantCard(resName:String,status:Boolean,navController: NavController,index:Int){
    val openOrclose:String;
    val signalColor:Color;
    if (status) {
        signalColor= Color.White
        openOrclose = "Open"
    }
//
    else {
        signalColor= Color.Red
        openOrclose = "Close"
    }

    Card(
        modifier = Modifier
            .padding(15.dp)
            .height(90.dp)
            .fillMaxWidth()
            .clickable {
                selectedResID =index
                navController.navigate("ItemClass")
            },
        colors = CardDefaults.cardColors(Color(0xFF84A59D)),
        shape = RoundedCornerShape(20.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        Text(
            text=resName,
            textAlign = TextAlign.Left,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(170.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            Modifier.background(
                shape = CircleShape,
                color = signalColor
            )
        ){
            Text(
            text = openOrclose,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(10.dp)
//                        .height(140.dp)
        )}
        }
    }
    }
        }
    }