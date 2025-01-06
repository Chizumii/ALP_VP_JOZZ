package com.example.alp_vp_jozz.models

import com.google.gson.annotations.SerializedName

data class BeritaModel(
    @SerializedName("id") // Sesuaikan dengan nama field di API
    val id: Int,

    @SerializedName("title") // Nama field di API untuk judul berita
    val title: String,

    @SerializedName("content") // Nama field di API untuk isi berita
    val content: String,

    @SerializedName("author") // Nama field di API untuk penulis berita
    val author: String,

    @SerializedName("published_at") // Nama field di API untuk tanggal publikasi
    val publishedAt: String
)
