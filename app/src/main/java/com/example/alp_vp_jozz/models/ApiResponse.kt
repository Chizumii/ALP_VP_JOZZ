package com.example.alp_vp_jozz.models

data class ApiResponse<T>(
    val message: String,
    val data: T? = null
)