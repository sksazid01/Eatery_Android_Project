package com.example.eateryapp.SignUp

import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.example.abartry.RetrofitStuffs.MyApiService
import com.example.abartry.RetrofitStuffs.ServiceBuilder
import com.example.abartry.data.subscribe.SubscribeRequestParameters
import com.example.abartry.data.subscribe.SubscribeResponse
import com.example.abartry.data.unsubscribe.UnsubscribeRequestParameters
import com.example.abartry.data.unsubscribe.UnsubscribeResponse
import com.example.eateryapp.Data.localContext
import com.example.eateryapp.Data.navController
import com.example.eateryapp.Data.phoneNumber
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun subscriptionOn(navController: NavController) {
    val subscribeRequestParameters = SubscribeRequestParameters(
        appId = "APP_118916",
        password = "42bc5a246b7982d669866e5b56124328",
        mobile = phoneNumber
    )
    val destinationService = ServiceBuilder.buildService(MyApiService::class.java)
    val requestCall = destinationService.subscribe(subscribeRequestParameters)

    requestCall.enqueue(object : Callback<SubscribeResponse> {
        override fun onResponse(
            call: Call<SubscribeResponse>,
            response: Response<SubscribeResponse>
        ) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Toast.makeText(localContext,"Subscription request sent successfully", Toast.LENGTH_SHORT).show()
                Log.d("OTP", "Subscription request sent successfully: $apiResponse")
            } else {
                // Handle unsuccessful response
                Toast.makeText(localContext,"Failed to send subscription request", Toast.LENGTH_SHORT).show()
                Log.e("OTP", "Failed to send subscription request: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<SubscribeResponse>, t: Throwable) {
            // Handle failure
            Log.e("OTP", "Network error: ${t.message}")
        }
    })
}

fun subscriptionOff(navController: NavController) {
    val unsubscribeRequestParameters = UnsubscribeRequestParameters(
        appId = "APP_118916",
        password = "42bc5a246b7982d669866e5b56124328",
        mobile = phoneNumber
    )
    val destinationService = ServiceBuilder.buildService(MyApiService::class.java)
    val requestCall = destinationService.unsubscribe(unsubscribeRequestParameters)

    requestCall.enqueue(object : Callback<UnsubscribeResponse> {
        override fun onResponse(
            call: Call<UnsubscribeResponse>,
            response: Response<UnsubscribeResponse>
        ) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Toast.makeText(localContext,"UnSubscription request sent successfully", Toast.LENGTH_SHORT).show()
                Log.d("OTP", "Subscription request sent successfully: $apiResponse")
                navController.navigate("Login")

            } else {
                // Handle unsuccessful response
                Toast.makeText(localContext,"Failed to send UnSubscription request", Toast.LENGTH_SHORT).show()
                Log.e("OTP", "Failed to send UnSubscription request: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<UnsubscribeResponse>, t: Throwable) {
            // Handle failure
            Log.e("OTP", "Network error: ${t.message}")
        }
    })
}