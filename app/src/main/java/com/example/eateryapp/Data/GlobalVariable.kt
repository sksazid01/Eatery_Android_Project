package com.example.eateryapp.Data

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.database.FirebaseDatabase


var totalItemInCart =0
var selectedResID = 0
//var select


var resName =  mutableStateListOf<RestaurantName>()


//database section
var database: FirebaseDatabase = FirebaseDatabase.getInstance()

var totalUser:Int=0
var currentUserId:Int = 1