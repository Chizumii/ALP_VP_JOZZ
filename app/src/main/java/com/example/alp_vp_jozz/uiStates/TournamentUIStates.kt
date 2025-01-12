package com.example.alp_vp_jozz.uiStates

import com.example.alp_vp_jozz.models.TournamentResponse

sealed interface TournamentDataStatusUIState {
    data class Success(val data: List<TournamentResponse>) : TournamentDataStatusUIState
    object Start : TournamentDataStatusUIState
    object Loading : TournamentDataStatusUIState
    data class Failed(val errorMessage: String) : TournamentDataStatusUIState
}
