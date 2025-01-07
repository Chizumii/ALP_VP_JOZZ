package com.example.alp_vp_jozz.uiStates

sealed interface AuthenticationStatusUIState {
    data class Success(val userModelData: UserResponse): AuthenticationStatusUIState
    object Loading: AuthenticationStatusUIState
    object Start: AuthenticationStatusUIState
    data class Failed(val errorMessage: String): AuthenticationStatusUIState
}