package com.example.alp_vp_jozz.uiStates

import com.example.alp_vp_jozz.models.UserModel

sealed interface AuthenticationStatusUIState {
    data class Success(val userModelData: UserModel): AuthenticationStatusUIState
    object Loading: AuthenticationStatusUIState
    object Start: AuthenticationStatusUIState
    data class Failed(val errorMessage: String): AuthenticationStatusUIState
}