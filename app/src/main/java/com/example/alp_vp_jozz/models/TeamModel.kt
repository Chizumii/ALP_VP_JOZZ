package com.example.alp_vp_jozz.models

data class CreateTeamRequest(
    val teamName: String,
    val gameID: String,
    val nickname: String,
    val logo: String,
    val leaderPhoneNumber: String
)

data class TeamResponse(
    val teamID: Int,
    val teamName: String,
    val gameID: String,
    val nickname: String,
    val logo: String,
    val leaderPhoneNumber: String
)
