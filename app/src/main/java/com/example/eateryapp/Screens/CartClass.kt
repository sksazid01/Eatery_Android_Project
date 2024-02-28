package com.example.eateryapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.Data.RestaurantItems
import com.example.eateryapp.Data.itm
import com.example.eateryapp.Data.totalItemInCart
import com.example.eateryapp.R

class CartClass {
        companion object{
            @Composable
            fun View10(navController: NavController)
            {

                val configuration = LocalConfiguration.current
                val screenWidthDp = configuration.screenWidthDp.dp
                val screenHeightDp = configuration.screenHeightDp.dp


//                val scrollState = rememberScrollState()

                Box(
//                        contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(screenWidthDp)
                        .height(screenHeightDp - 100.dp)
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
                        modifier = Modifier.padding(30.dp)
                    ) {
                        Text(text = " "+"Selected"+" items in cart", fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)



                        var isPressClear by remember { mutableStateOf(false) }

                        Box(modifier=Modifier.height(screenHeightDp-350.dp)) {
                                LazyColumn(
                                    content = {
                                        isPressClear=false
                                        items(itm) { item ->
//                                            if(item.numberOfSelection>0)
//                                                CartItem(item, navController);
                                        }
                                    },
                                )
                        }





                        Spacer(modifier = Modifier.weight(1f))
//                        Text("Order instructions",
//                            textAlign = TextAlign.Center,
//                            modifier = Modifier.padding(bottom = 5.dp, start = 5.dp)
//                        )
                        var textfield by remember {mutableStateOf("") }
                        OutlinedTextField(
                            value =textfield ,
                            onValueChange ={ textfield=it},
                            singleLine = true,

                            label = { Text(text = "Provide a short instruction", textAlign = TextAlign.Center, modifier = Modifier.padding(5.dp))},
//                            colors = TextFieldDefaults.colors()

                            modifier= Modifier
                                .fillMaxWidth()
                                .height(65.dp)
                                .padding(start = 10.dp, end = 10.dp),
                            shape = RoundedCornerShape(20.dp)
                        )
                        Text(text = "Total: ", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(start = 15.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            modifier= Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .height(50.dp),
//                                .background(Color(0xFF644AB5)), wrong approach
                            colors = ButtonDefaults.buttonColors(Color(0xFF644AB5)),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = "Checkout",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 4.em
                            )
                        }
                        Row {

                        Spacer(modifier = Modifier.weight(1f))
//                        Text(
//                            text="Back to Menu",
//                            fontWeight = FontWeight.ExtraBold
////                                modifier = Modifier.
////                            textAlign = TextAlign.Center
//                        )
//                        Spacer(modifier = Modifier.weight(1f))
                    }
//                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            }
        @Composable
        fun CartItem(item: RestaurantItems, navController: NavController){
           OutlinedCard (
               modifier = Modifier
                   .padding(5.dp)
                   .height(90.dp)
//                   .background(Color.Red)
                   .fillMaxWidth()
           ){
               Row(
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
                   var value by remember { mutableIntStateOf(item.numberOfSelection!!) }
                   Image(
                       painter = painterResource(id = "R.drawable.beef".toInt()), contentDescription = "",
                       alignment = Alignment.CenterStart,
                       modifier = Modifier.size(90.dp),
//                       contentScale = ContentScale.Fit,
                   )
                   Spacer(modifier = Modifier.weight(1f))

                   Column(
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally,
                       modifier = Modifier
                           .background(Color.Transparent)
                           .fillMaxHeight()
                   ) {
                       Text(text = item.itemName!!)
                       Text(text = item.price.toString()+"৳",
//                           textAlign = TextAlign.Center
                             fontWeight = FontWeight.ExtraBold
                           )


                       Row {
                           Icon(painter = painterResource(id = R.drawable.baseline_remove_24), contentDescription ="",modifier = Modifier.clickable {
                                value--
                                totalItemInCart--
                                item.numberOfSelection=item.numberOfSelection!! - 1
                               if(value<1) {
                                   value = 1;
                                   item.numberOfSelection = 1;
                                   totalItemInCart++
                               }
                           } )

                           Text(text = "  $value  ")
                           Icon(imageVector = Icons.Default.Add, contentDescription = "",modifier = Modifier.clickable {
                                value++
                                totalItemInCart++
                                item.numberOfSelection?.let {
                                    item.numberOfSelection = item.numberOfSelection!! + 1
                                }
                           })
                       }
                   }
               Spacer(modifier = Modifier.weight(1f))
               Icon(imageVector = Icons.Default.Clear, contentDescription = "", modifier = Modifier.clickable {
                   item.numberOfSelection=0;
                   item.isSelected=false
                   value=0;
                   navController.navigate("CartClass")
               })
           }}
        }
        }
}