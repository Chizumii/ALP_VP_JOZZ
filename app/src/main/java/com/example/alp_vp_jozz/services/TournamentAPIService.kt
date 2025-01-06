package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.createTournament
import com.example.alp_vp_jozz.models.getAllTournament
import com.example.alp_vp_jozz.repositories.ResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TournamentApiService {

    // Endpoint untuk mendapatkan semua tournament
    @GET("tournaments")
    suspend fun getAllTournaments(): getAllTournament

    // Endpoint untuk menambahkan tournament baru
    @POST("tournaments")
    suspend fun createTournament(@Body tournament: createTournament): ResponseModel
}
