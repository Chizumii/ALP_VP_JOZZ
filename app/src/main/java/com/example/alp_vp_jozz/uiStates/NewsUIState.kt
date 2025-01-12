package com.example.alp_vp_jozz.uiStates

import com.example.alp_vp_jozz.models.BeritaModel

sealed class NewsUIState {
    object Idle : NewsUIState()
    object Loading : NewsUIState()
    data class Success(val beritaList: List<BeritaModel> = emptyList()) : NewsUIState()
    data class Error(val message: String) : NewsUIState()
}
