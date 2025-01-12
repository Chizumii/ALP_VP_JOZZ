package com.example.alp_vp_jozz.uiStates

sealed interface NewsDataStatusUIState {
    data class Success(val data: String): NewsDataStatusUIState
    object Start: NewsDataStatusUIState
    object Loading: NewsDataStatusUIState
    data class Error(val errorMessage: String): NewsDataStatusUIState
}