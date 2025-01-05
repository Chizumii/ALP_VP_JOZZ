package com.example.alp_vp_jozz.models

data class UserResponse(
    val data: UserModel
)

data class UserModel(
    val username: String,
    val token: String?
)