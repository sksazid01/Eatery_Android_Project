package com.example.eateryapp.SignUp

import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.example.abartry.RetrofitStuffs.MyApiService
import com.example.abartry.RetrofitStuffs.ServiceBuilder
import com.example.abartry.data.otpVerify.OtpVerifyRespone
import com.example.abartry.data.otpVerify.VerifyParameters
import com.example.abartry.data.subscription.StatusResponse
import com.example.abartry.data.subscription.VerifyParametersStatus
import com.example.eateryapp.Data.localContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val verifyParameters = VerifyParameters(
    appId = "APP_118916",
    password = "42bc5a246b7982d669866e5b56124328",
    referenceNo = "",
    otp = ""
)
fun checkOTP(otp: String,navController: NavController){
    verifyParameters.otp = otp
    Log.d("OTP", "${verifyParameters}")
    val destinationService = ServiceBuilder.buildService(MyApiService::class.java)
    val requestCall = destinationService.verifyOtp(verifyParameters)

    requestCall.enqueue(object : Callback<OtpVerifyRespone> {
        override fun onResponse(
            call: Call<OtpVerifyRespone>,
            response: Response<OtpVerifyRespone>
        ) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Log.d("OTP", "OTP verified successfully: $apiResponse")
                navController.navigate("MapClass")
            } else {
                // Handle unsuccessful response
                Log.e("OTP", "Failed to verify OTP: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<OtpVerifyRespone>, t: Throwable) {
            // Handle failure
            Log.e("OTP", "Network error: ${t.message}")
        }

    })
}

fun verifyStatus() {
    val verifyParametersStatus = VerifyParametersStatus(
        appId = "APP_118916",
        password = "42bc5a246b7982d669866e5b56124328",
        mobile = "8801835221635"
    )
    val destinationService = ServiceBuilder.buildService(MyApiService::class.java)
    val requestCall = destinationService.verifySubscription(verifyParametersStatus)

    requestCall.enqueue(object : Callback<StatusResponse> {
        override fun onResponse(call: Call<StatusResponse>, response: Response<StatusResponse>) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Log.d("OTP", "Subscription Status verified successfully: $apiResponse")
            } else {
                // Handle unsuccessful response
                Log.e("OTP", "Failed to verify Subscription Status: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<StatusResponse>, t: Throwable) {
            // Handle failure
            Log.e("OTP", "Network error: ${t.message}")
        }
    })
}