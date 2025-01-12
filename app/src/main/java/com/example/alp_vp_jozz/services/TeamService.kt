package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.CreateTeamRequest
import com.example.alp_vp_jozz.models.TeamResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TeamServiceApi {
    @POST("/teams")
    fun createTeam(@Body request: CreateTeamRequest): Call<TeamResponse>

    @GET("/teams/{id}")
    suspend fun getTeam(@Path("id") teamID: Int): Response<TeamResponse>
}
