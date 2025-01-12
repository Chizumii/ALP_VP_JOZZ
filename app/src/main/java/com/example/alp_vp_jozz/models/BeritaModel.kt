package com.example.alp_vp_jozz.models

import com.google.gson.annotations.SerializedName

// Data class for creating news
data class CreateBerita(
    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("author")
    val author: String
)

// Data class for the response of the news
data class BeritaResponse(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("title")
    val title: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("image")
    val image: String = "",

    @SerializedName("author")
    val author: String = ""
)

// Data class for a list of news
data class ListBerita(
    @SerializedName("data")
    val data: List<BeritaResponse>
)

// Data class for updating the news
data class UpdateBerita(
    @SerializedName("title")
    val title: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("image")
    val image: String = "",

    @SerializedName("author")
    val author: String = ""
)

// Data class for deleting news
data class DeleteBerita(
    @SerializedName("id")
    val id: Int = 0
)
