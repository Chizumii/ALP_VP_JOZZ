package com.example.alp_vp_jozz.repositories

import com.example.alp_vp_jozz.models.createTournament
import com.example.alp_vp_jozz.models.getAllTournament

interface TournamentRepository {
    suspend fun getAllTournaments(): getAllTournament
    suspend fun addTournament(tournament: createTournament): ResponseModel
}

data class ResponseModel(
    val success: Boolean,
    val message: String? = null
)
