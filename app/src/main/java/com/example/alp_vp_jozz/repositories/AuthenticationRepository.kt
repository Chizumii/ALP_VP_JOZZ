package com.example.alp_vp_jozz.repositories

import com.example.alp_vp_jozz.models.UserResponse
import com.example.alp_vp_jozz.services.AuthenticationAPIService
import retrofit2.Call


interface AuthenticationRepository {
    fun register(username: String, email: String, password: String): Call<UserResponse>

    fun login(email: String, password: String): Call<UserResponse>
}

class NetworkAuthenticationRepository(
    private val authenticationAPIService: AuthenticationAPIService
): AuthenticationRepository {
    override fun register(username: String, email: String, password: String): Call<UserResponse> {
        var registerMap = HashMap<String, String>()

        registerMap["username"] = username
        registerMap["email"] = email
        registerMap["password"] = password

        return authenticationAPIService.register(registerMap)
    }

    override fun login(username: String, password: String): Call<UserResponse> {
        var loginMap = HashMap<String, String>()

        loginMap["username"] = username
        loginMap["password"] = password

        return authenticationAPIService.login(loginMap)
    }
}