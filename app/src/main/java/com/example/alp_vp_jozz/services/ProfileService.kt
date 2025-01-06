package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.UserResponse
import com.example.alp_vp_jozz.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProfileService {

    @GET("users/{id}")
    fun getUserProfile(
        @Header("X-API-TOKEN") token: String,
        @Path("id") id: Int
    ): Call<UserResponse>

    @POST("users")
    fun createUserProfile(
        @Header("X-API-TOKEN") token: String,
        @Body userModel: UserModel
    ): Call<UserResponse>

    @PUT("users/{id}")
    fun updateUserProfile(
        @Header("X-API-TOKEN") token: String,
        @Path("id") id: Int,
        @Body userModel: UserModel
    ): Call<UserResponse>

    @DELETE("users/{id}")
    fun deleteUserProfile(
        @Header("X-API-TOKEN") token: String,
        @Path("id") id: Int
    ): Call<UserResponse>
}
