package com.example.abartry.data.unsubscribe

data class UnsubscribeResponse(
    val statusCode: String,
    val statusDetail: String,
    val subscriptionStatus: String,
    val version: String
)
