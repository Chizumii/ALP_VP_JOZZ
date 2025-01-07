package com.example.alp_vp_jozz.services

// network/UserApi.kt
import com.example.alp_vp_jozz.models.ApiResponse
import com.example.alp_vp_jozz.models.GeneralResponseModel
import com.example.alp_vp_jozz.models.LoginUserRequest
import com.example.alp_vp_jozz.models.RegisterUserRequest
import com.example.alp_vp_jozz.models.UpdateUserRequest
import com.example.alp_vp_jozz.models.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserServiceApi {

    @POST("/api/user")
    suspend fun register(@Header("X-API-TOKEN") token: String, @Body request: RegisterUserRequest): UserResponse

    @POST("/api/login")
    suspend fun login(@Header("X-API-TOKEN") token: String, @Body request: LoginUserRequest): UserResponse

    @PUT("/api/user")
    suspend fun updateUser(@Header("X-API-TOKEN") token: String, @Body request: UpdateUserRequest): UserResponse

    @POST("api/logout")
    fun logout(@Header("X-API-TOKEN") token: String): Call<GeneralResponseModel>
}

