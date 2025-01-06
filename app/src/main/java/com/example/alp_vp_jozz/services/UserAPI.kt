package com.example.alp_vp_jozz.services

// network/UserApi.kt
import com.example.alp_vp_jozz.models.ApiResponse
import com.example.alp_vp_jozz.models.LoginUserRequest
import com.example.alp_vp_jozz.models.RegisterUserRequest
import com.example.alp_vp_jozz.models.UpdateUserRequest
import com.example.alp_vp_jozz.models.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserApi {

    @POST("/api/register") // Sesuaikan dengan endpoint backend Anda
    suspend fun registerUser(
        @Body request: RegisterUserRequest
    ): ApiResponse<UserResponse>

    @POST("/api/login") // Sesuaikan dengan endpoint backend Anda
    suspend fun loginUser(
        @Body request: LoginUserRequest
    ): ApiResponse<UserResponse>

    @PUT("/api/user/{id}") // Sesuaikan dengan endpoint backend Anda
    suspend fun updateUser(
        @Path("id") userId: String,
        @Body request: UpdateUserRequest,
        @Header("Authorization") token: String
    ): ApiResponse<UserResponse>

    @POST("/api/logout") // Sesuaikan dengan endpoint backend Anda
    suspend fun logoutUser(
        @Header("Authorization") token: String
    ): ApiResponse<String>
}
