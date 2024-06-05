package com.example.abartry.RetrofitStuffs

import com.example.abartry.data.otpRequest.ApiResponse
import com.example.abartry.data.otpVerify.OtpVerifyRespone
import com.example.abartry.data.otpRequest.RequestParameters
import com.example.abartry.data.otpVerify.VerifyParameters
import com.example.abartry.data.subscribe.SubscribeRequestParameters
import com.example.abartry.data.subscribe.SubscribeResponse
import com.example.abartry.data.subscription.StatusResponse
import com.example.abartry.data.subscription.VerifyParametersStatus
import com.example.abartry.data.unsubscribe.UnsubscribeRequestParameters
import com.example.abartry.data.unsubscribe.UnsubscribeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApiService {
    @POST("nazmul/subscription/otp/request")
    fun requestOtp(@Body requestParameters: RequestParameters): Call<ApiResponse>

    @POST("nazmul/subscription/otp/verify")
    fun verifyOtp(@Body verifyParameters: VerifyParameters): Call<OtpVerifyRespone>

    @POST("nazmul/subscription/status ")
    fun verifySubscription(@Body verifyParametersStatus: VerifyParametersStatus): Call<StatusResponse>

    @POST("nazmul/subscription/subscribe ")
    fun subscribe(@Body subscribeRequestParameters: SubscribeRequestParameters): Call<SubscribeResponse>

    @POST("nazmul/subscription/unsubscribe ")
    fun unsubscribe(@Body unsubscribeRequestParameters: UnsubscribeRequestParameters): Call<UnsubscribeResponse>
}
