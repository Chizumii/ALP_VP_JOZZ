package com.example.alp_vp_jozz.models

import com.google.gson.annotations.SerializedName

data class BeritaModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("author") val author: String,
    @SerializedName("published_at") val publishedAt: String
)
