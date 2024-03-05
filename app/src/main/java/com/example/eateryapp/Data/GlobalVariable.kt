package com.example.eateryapp.Data

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase


var totalItemInCart:Int=0
var selectedResID = -1


var resName =  mutableStateListOf<RestaurantName>()
var itm : List<RestaurantItems> = emptyList()


//database section
var database: FirebaseDatabase = FirebaseDatabase.getInstance()

@SuppressLint("StaticFieldLeak")
lateinit var localContext: Context


var totalUser:Int=0
var currentUserId:Int = 1

var ok : Boolean = false

@SuppressLint("StaticFieldLeak")
lateinit var navController: NavController
@SuppressLint("StaticFieldLeak")
lateinit var navController2: NavController