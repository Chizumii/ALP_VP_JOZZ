package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.GeneralResponseModel
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST

interface UserAPIService {
    @POST("api/logout")
    fun logout(@Header("X-API-TOKEN") token: String): Call<GeneralResponseModel>
}