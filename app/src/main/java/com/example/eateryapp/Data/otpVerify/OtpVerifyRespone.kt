package com.example.abartry.data.otpVerify

data class OtpVerifyRespone(
    val statusCode: String,
    val version: String,
    val subscriptionStatus: String,
    val statusDetail: String,
    val subscriberId: String
)
