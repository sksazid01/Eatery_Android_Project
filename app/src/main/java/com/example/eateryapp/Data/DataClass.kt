package com.example.eateryapp.Data

data class RestaurantName(
    var name:String,
    var status:Boolean,
    var id:Int,
    var items:List<RestaurantItems>//?=null

)

data class RestaurantItems(
    var itemName: String?="no name",
    var price:Int?=null,
    var image: String?=null,
    var id:Int?=null,
    var numberOfSelection:Int?=0,
    var isSelected:Boolean?=false
)

//signup data
data class SingUPData(
    var name:String,
    var mail:String,
    var pass:String
)