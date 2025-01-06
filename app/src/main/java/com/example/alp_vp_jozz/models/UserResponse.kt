package com.example.alp_vp_jozz.models

import com.google.gson.annotations.SerializedName


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

data class GetUserModel(
    val username: String,
    @SerializedName("profile_image") val profileImage: String
)


