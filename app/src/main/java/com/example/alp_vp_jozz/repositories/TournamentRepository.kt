package com.example.alp_vp_jozz.repositories

import com.example.alp_vp_jozz.models.GeneralResponseModel
import com.example.alp_vp_jozz.models.TournamentRequest
import com.example.alp_vp_jozz.models.TournamentResponse
import com.example.alp_vp_jozz.services.TournamentServiceApi
import retrofit2.Call


interface TournamentRepository {
    fun createTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<GeneralResponseModel>

    fun updateTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse>

    fun deleteTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse>

    fun getALLTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse>
}


class NetworkTournamentRepository(
    private val tournamentServiceApi: TournamentServiceApi
) : TournamentRepository {

    override fun getALLTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse> {
        val token = "X-API-SERVICE"
        return tournamentServiceApi.getAllTournament(
            token,
            namaTournament,
            description,
            image,
            tipe,
            biaya,
            lokasiID
        )
    }

    override fun createTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<GeneralResponseModel> {
        val token = "X-API-SERVICE"
        return tournamentServiceApi.createTournament(
            token,
            namaTournament,
            description,
            image,
            tipe,
            biaya,
            lokasiID
        )
    }

    override fun updateTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse> {
        val token = "X-API-SERVICE"
        return tournamentServiceApi.updateTournament(
            token,
            namaTournament,
            description,
            image,
            tipe,
            biaya,
            lokasiID
        )

    }

    override fun deleteTournament(
        namaTournament: String,
        description: String,
        image: String,
        tipe: String,
        biaya: String,
        lokasiID: Int
    ): Call<TournamentResponse> {
        val token = "X-API-SERVICE"
        return tournamentServiceApi.deleteTournament(
            token,
            namaTournament,
            description,
            image,
            tipe,
            biaya,
            lokasiID
        )
    }
}

