package com.example.eateryapp.Data

import android.util.Log
import androidx.compose.runtime.Composable
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Context
import com.google.firebase.database.getValue


@Composable
fun LoadFromMain() {
    loadRestaurentData()
    loadTotalUser()
    WriteToFile("sk.txt","nothing")
}

fun currentUserId(){

}

fun loadTotalUser(){
    val reference = database.reference.child("totalUser")
    reference.addListenerForSingleValueEvent(
        object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                totalUser = snapshot.getValue(Int::class.java)!!
//                Log.d("global","totalUser = $totalUser")
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
    )
}

@Composable
fun loadRestaurentData(){
    database = FirebaseDatabase.getInstance()
//    Log.d("MyTag", "load entry")
    val reference: DatabaseReference = database.reference.child("restaurants")
//    Log.d("MyTag", "created reference")
    reference.addListenerForSingleValueEvent(
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
//                if(!snapshot.exists()) Log.d("MyTag","null snap")
//                else Log.d("MyTag","snaps to go")
                for (snap in snapshot.children) {
//                    Log.d("MyTag", "snaps available")
                    val name = snap.child("name").value.toString()
                    val id: Int = (snap.child("id").value as? Long)?.toInt() ?: -1 // Handle null or non-integer values
                    val status = snap.child("status").value.toString().toBoolean() // Default to false if null or non-boolean
//                    val items = snap.child("items").child("night").getValue<List<RestaurantItems>>()
//                    val items = snap.child("items").children


                    val itemL: MutableList<AllItems> = mutableListOf()

                    val keysToFetch = listOf("night", "evening","morning") // Add more keys if needed

                    for (key in keysToFetch) {
                        val temp = snap.child("items").child(key).getValue<List<RestaurantItems>>()
                            ?.let { AllItems(key, it) }
                        temp?.let { itemL.add(it) }
                    }

                    val resNm = RestaurantName(name, status, id, itemL)
//                    itm = items
                    resName.add(resNm)
                }
//                Log.d("MyTag", itm.toString())
//                itm.addAll(itm)
            }

            override fun onCancelled(error: DatabaseError) {

//                Log.d("MyTag", "cancel")
            }
        }
    )
}