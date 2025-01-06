package com.example.alp_vp_jozz.uiStates

sealed interface StringDataStatusUIState {
    data class Success(val data: String): StringDataStatusUIState
    object Start: StringDataStatusUIState
    object Loading: StringDataStatusUIState
    data class Error(val errorMessage: String): StringDataStatusUIState
}