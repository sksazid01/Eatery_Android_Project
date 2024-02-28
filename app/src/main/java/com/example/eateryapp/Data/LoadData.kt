package com.example.eateryapp.Data

import android.util.Log
import androidx.compose.runtime.Composable
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue


@Composable
fun LoadFromMain() {
    loadRestaurentData()
    loadTotalUser()

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
                    val id: Int = (snap.child("id").value as? Long)?.toInt()
                        ?: -1 // Handle null or non-integer values
                    val status = snap.child("status").value as? Boolean
                        ?: false // Default to false if null or non-boolean
                    val items = snap.child("items").getValue<List<RestaurantItems>>()
                    val resNm = RestaurantName(name, status, id, items!!)

                    itm = items
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