package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.GeneralResponseModel
import com.example.alp_vp_jozz.models.TournamentRequest
import com.example.alp_vp_jozz.models.TournamentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TournamentServiceApi {

    @POST("/api/tournaments")
    fun createTournament(
        @Header("X-API-TOKEN") token: String,  @Query("namaTournament") namaTournament: String,
        @Query("description") description: String,
        @Query("image") image: String,
        @Query("tipe") tipe: String,
        @Query("biaya") biaya: String,
        lokasiID: Int,
    ): Call<GeneralResponseModel>

    @GET("/api/tournaments")
    fun getAllTournament(
        @Header("X-API-TOKEN") token: String,
        @Query("namaTournament") namaTournament: String,
        @Query("description") description: String,
        @Query("image") image: String,
        @Query("tipe") tipe: String,
        @Query("biaya") biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse>


    @GET("/api/tournaments/{id}")
    fun getTournamentById(
        @Header("X-API-TOKEN") token: String, @Path("id") id: Int
    ): Call<TournamentResponse>

    @PUT("/api/tournaments/{id}")
    fun updateTournament(
        @Header("X-API-TOKEN") token: String,
        @Path("id") id: String,
        @Body request: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse>

    @DELETE("/api/tournaments/{id}")
    fun deleteTournament(
        @Header("X-API-TOKEN") token: String,
        @Path("id") id: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse>
}
