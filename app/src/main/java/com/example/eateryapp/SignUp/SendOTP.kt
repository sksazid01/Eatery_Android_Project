package com.example.eateryapp.SignUp

import android.util.Log
import androidx.navigation.NavController
import com.example.abartry.RetrofitStuffs.MyApiService
import com.example.abartry.RetrofitStuffs.ServiceBuilder
import com.example.abartry.data.otpRequest.ApiResponse
import com.example.abartry.data.otpRequest.RequestParameters
import com.example.eateryapp.Data.phoneNumber
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun sendOTP(navController:NavController) {
    val requestParameters = RequestParameters(
        appId = "APP_118916",
        password = "42bc5a246b7982d669866e5b56124328",
        mobile = phoneNumber
    )


    val destinationService = ServiceBuilder.buildService(MyApiService::class.java)
    val requestCall = destinationService.requestOtp(requestParameters)

    requestCall.enqueue(object : Callback<ApiResponse> {
        override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                if (apiResponse != null) {
                    verifyParameters.referenceNo = apiResponse.referenceNo
                }
                Log.d("OTP", "OTP sent successfully: $apiResponse")
                navController.navigate("OTP")

            } else {
                // Handle unsuccessful response
                Log.e("OTP", "Failed to send OTP: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            // Handle failure
            Log.e("OTP", "Network error: ${t.message}")
        }
    })
}