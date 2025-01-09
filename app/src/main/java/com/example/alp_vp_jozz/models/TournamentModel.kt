package com.example.alp_vp_jozz.models

// TournamentModel.kt
// Data class untuk membuat tournament baru
data class CreateTournament(
    val namaTournament: String,
    val description: String,
    val image: String,
    val tipe: String,
    val biaya: String,
    val lokasiID: Int
)

// Data class untuk respons tournament
data class TournamentResponse(
    val tournamentID: Int = 0,
    val namaTournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val lokasiID: Int = 0
)

// Data class untuk permintaan tournament (misalnya, saat mengambil detail tertentu)
data class TournamentRequest(
    val namaTournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val lokasiID: Int = 0
)

// Data class untuk memperbarui tournament
data class UpdateTournament(
    val namaTournament: String = "",
    val description: String ="",
    val image: String ="",
    val tipe: String ="",
    val biaya: String ="",
    val lokasiID: Int =0
)

// Data class untuk menghapus tournament
data class DeleteTournament(
    val namaTournament: String = "",
    val description: String ="",
    val image: String ="",
    val tipe: String ="",
    val biaya: String ="",
    val lokasiID: Int =0
)

// Data class untuk mendapatkan semua tournament
data class GetAllTournament(
    val namaTournament: String = "",
    val description: String ="",
    val image: String ="",
    val tipe: String ="",
    val biaya: String ="",
    val lokasiID: Int =0
)






