package com.example.alp_vp_jozz.repositories

import com.example.alp_vp_jozz.models.CreateTeamRequest
import com.example.alp_vp_jozz.models.TeamResponse
import retrofit2.Call
import retrofit2.Response

interface TeamRepository {
    fun createTeam(request: CreateTeamRequest): Call<TeamResponse>
    suspend fun getTeam(teamID: Int): Response<TeamResponse>
}

class NetworkTeamRepository(
    private val teamServiceApi: TeamServiceApi
) : TeamRepository {
    override fun createTeam(request: CreateTeamRequest): Call<TeamResponse> {
<<<<<<< Updated upstream
        return teamServiceApi.createteam(request)
=======
        return teamServiceApi.createTeam(request)
>>>>>>> Stashed changes
    }

    override suspend fun getTeam(teamID: Int): Response<TeamResponse> {
        return teamServiceApi.getTeam(teamID)
    }
}
