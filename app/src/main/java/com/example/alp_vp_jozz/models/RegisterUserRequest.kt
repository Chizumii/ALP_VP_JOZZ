package com.example.alp_vp_jozz.models

data class RegisterUserRequest(
    val username: String,
    val email: String,
    val password: String,
    val nama_depan: String,
    val nama_belakang: String,
    val nomor_telp: String,
    val nicknamegame: String,
    val TeamID: Int
)