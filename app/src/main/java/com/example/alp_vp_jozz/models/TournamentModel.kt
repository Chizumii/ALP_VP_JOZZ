package com.example.alp_vp_jozz.models

// TournamentModel.kt
// Data class untuk membuat tournament baru
data class CreateTournament(
    val nama_tournament: String,
    val description: String,
    val image: String,
    val tipe: String,
    val biaya: String,
    val LokasiID: Int
)

data class listTournament(
    val data: List<TournamentResponse>
)

// Data class untuk respons tournament
data class TournamentResponse(
    val TournamentID: Int = 0,
    val nama_tournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val LokasiID: Int = 0
)

// Data class untuk permintaan tournament (misalnya, saat mengambil detail tertentu)
data class TournamentRequest(
    val nama_tournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val LokasiID: Int = 0
)

// Data class untuk memperbarui tournament
data class UpdateTournament(
    val namaTournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val LokasiID: Int = 0
)

// Data class untuk menghapus tournament
data class DeleteTournament(
    val namaTournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val LokasiID: Int = 0
)

// Data class untuk mendapatkan semua tournament
data class GetAllTournament(
    val namaTournament: String = "",
    val description: String = "",
    val image: String = "",
    val tipe: String = "",
    val biaya: String = "",
    val lokasiID: Int = 0
)






