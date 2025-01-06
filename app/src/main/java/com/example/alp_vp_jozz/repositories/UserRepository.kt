package com.example.alp_vp_jozz.repositories

// repository/UserRepository.kt
// data/repository/UserRepository.kt
import com.example.alp_vp_jozz.models.ApiResponse
import com.example.alp_vp_jozz.models.RegisterUserRequest
import com.example.alp_vp_jozz.models.UserResponse
import com.example.alp_vp_jozz.services.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: String): Result<Nothing>()
}

class UserRepository @Inject constructor(private val api: UserApi) {

    suspend fun registerUser(request: RegisterUserRequest): Result<UserResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.registerUser(request)
                if (response.data != null) {
                    Result.Success(response.data)
                } else {
                    Result.Error(response.message)
                }
            } catch (e: Exception) {
                Result.Error(e.localizedMessage ?: "An unexpected error occurred")
            }
        }
    }

    // Tambahkan fungsi lain seperti login, update, logout jika diperlukan
}

