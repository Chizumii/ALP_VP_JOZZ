package com.example.alp_vp_jozz.uiStates

import com.example.alp_vp_jozz.models.BeritaModel

sealed interface BeritaSubmitUIState {
    data class Success(val data: List<BeritaModel>) : BeritaSubmitUIState
    object Start : BeritaSubmitUIState
    object Loading : BeritaSubmitUIState
    data class Error(val errorMessage: String) : BeritaSubmitUIState
}