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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.eateryapp.Data.RestaurantItems
import com.example.eateryapp.Data.resName
import com.example.eateryapp.Data.selectedResID
import com.example.eateryapp.Data.totalItemInCart
import com.example.eateryapp.R

class ItemClass {
    companion object{
        @Composable
        fun View08(navController: NavController){
            val configuration = LocalConfiguration.current
            val screenWidthDp = configuration.screenWidthDp.dp
            val screenHeightDp = configuration.screenHeightDp.dp

            Box(
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
                        Text(
                            text = resName[selectedResID].name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
//                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(35.dp))

                    var address by remember { mutableStateOf("") }

                    Row {
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
                                        "Search Items...",
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


                    LazyVerticalGrid(columns = GridCells.Fixed(2), content ={
                        items(resName[selectedResID].items){
                                item->
                            RestaurantCard(item)
                        }
//                        Spacer(modifier = Modifier.height(200.dp))
                    } )
                }
            }
        }

        @Composable
        fun RestaurantCard(item: RestaurantItems) {
            val itemName = item.itemName
            val price = item.price
            val image = item.image
            val id = item.id
            val borderColor = Color.Transparent

            var isSelected by remember { mutableStateOf(item.isSelected) }
            // Use LaunchedEffect to trigger recomposition when isSelected changes
            LaunchedEffect(isSelected) {
                item.isSelected = isSelected
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable {
                        isSelected = !isSelected!!
                        item.numberOfSelection = if (isSelected!!) 1 else 0;
                        totalItemInCart += item.numberOfSelection!!;
                    }
                    .background(if (isSelected!!) Color.Red else borderColor)
            ) {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(170.dp),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = image),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )

                        Row(){
                            Box(
                                Modifier
                                    .background(
                                        shape = CircleShape,
                                        color = Color.White
                                    )
                                    .padding(5.dp)
                            ) {
                                Text(
                                    text = price.toString() + "৳",
                                    textAlign = TextAlign.End,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                Modifier
                                    .padding(top = 20.dp, end = 7.dp)
                                    .background(
                                        shape = CircleShape,
                                        color = Color.Black
                                    )

                            ) {
                                Text(
                                    text = ((12354*Math.random())%100).toInt().toString() + " left",
                                    textAlign = TextAlign.End,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    modifier = Modifier.padding(2.dp)
                                )
                            }
                        }
                    }
                }
                Text(
                    text = itemName!!,
                    textAlign = TextAlign.Left,
                    fontSize = 4.em,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

    }
    }
