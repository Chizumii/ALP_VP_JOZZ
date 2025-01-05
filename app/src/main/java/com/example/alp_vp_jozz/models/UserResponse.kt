package com.example.alp_vp_jozz.models


data class UserResponse(
    val status: Int,
    val message: String,
    val data: UserModel
)

data class UserModel(
    val username: String,
    val token: String?
)

data class GetUserResponse(
    val status: Int,
    val message: String,
    val data: GetUserModel
)
