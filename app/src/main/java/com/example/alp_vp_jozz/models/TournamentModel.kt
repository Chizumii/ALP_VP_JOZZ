package com.example.alp_vp_jozz.models

data class TournamentModel(
    val id: Int, // ID Tournament dari backend
    val name_tournament: String,
    val description: String, // Nama properti konsisten dengan deskripsi
    val image: String,
    val tipe: String,
    val biaya: String,
    val lokasiID: Int
)

data class createTournament(
    val name_tournament: String,
    val description: String,
    val image: String,
    val tipe: String,
    val biaya: String,
    val lokasiID: Int // Ditambahkan karena backend membutuhkannya
)

data class getAllTournament(
    val data: List<TournamentModel>?,
    val message: String?,
    val error: Boolean = false // Properti tambahan untuk error handling
)






