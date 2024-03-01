package com.example.eateryapp.Data

import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.database.FirebaseDatabase


var totalItemInCart:Int=0
var selectedResID = -1
//var select


var resName =  mutableStateListOf<RestaurantName>()
var itm : List<RestaurantItems> = emptyList()


//database section
var database: FirebaseDatabase = FirebaseDatabase.getInstance()

var totalUser:Int=0
var currentUserId:Int = 1