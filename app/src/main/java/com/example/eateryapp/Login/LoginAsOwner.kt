package com.example.eateryapp.Login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eateryapp.Data.localContext
import com.example.eateryapp.R

@Composable
fun OwnerUI(navController:NavController){
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
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ) {

            var name by remember { mutableStateOf("") }
            OutlinedTextField(
                value =name ,
                onValueChange ={ name=it},
                singleLine = true,
                label = { Text(text = "Provide Item Name") },
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 10.dp),
                shape = RoundedCornerShape(20.dp)
            )

            var price by remember { mutableStateOf("") }
            OutlinedTextField(
                value =price ,
                onValueChange ={ price=it},
                singleLine = true,
                label = { Text(text = "Provide Item Price") },
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 10.dp),
                shape = RoundedCornerShape(20.dp)
            )

            var total by remember { mutableStateOf("") }
            OutlinedTextField(
                value = total ,
                onValueChange ={ total=it},
                singleLine = true,
                label = { Text(text = "Number Of Cooked Items") },
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 10.dp),
                shape = RoundedCornerShape(20.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 20.dp, top = 10.dp),
            ){
                Text(text = "Upload Image Here:", fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.upload), contentDescription = "")
                }
            }
            Button(
                onClick = {
                    Toast.makeText(localContext,"Currently Unable this feature!!",Toast.LENGTH_SHORT).show()
                },

                modifier = Modifier
                    .padding(5.dp)
                    .size(250.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1FCE6B)),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "Upload New Item Info",
                    color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                )
            }

            Text(
                text = "If you want to upgrade Item Info,\nPlease Provide Item ID and Press The below Button"
            )

            var upgrade by remember {
                mutableStateOf("")
            }
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value = upgrade, onValueChange ={upgrade = it},
                    modifier = Modifier.width(130.dp).height(60.dp),
                    shape = RoundedCornerShape(30.dp),
                    singleLine = true
                )
                Button(
                    onClick = {
                        Toast.makeText(localContext,"Provide Correct Information",Toast.LENGTH_SHORT).show()
                    },

                    modifier = Modifier
                        .padding(5.dp)
                        .size(160.dp, 40.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF1F88CE)),
                    shape = RoundedCornerShape(40.dp)
                ) {
                    Text(
                        text = "Upgrade Item",
                        color = Color.White
//                                fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            Button(
                onClick = {
                    Toast.makeText(localContext,"Successfully Logged Out",Toast.LENGTH_SHORT).show()
                    FlagManager.saveFlag(localContext, 1)
                    navController.navigate("Login")
                },

                modifier = Modifier
                    .padding(5.dp)
                    .size(160.dp, 35.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "LogOut",
                    color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}