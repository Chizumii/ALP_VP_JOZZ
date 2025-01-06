package com.example.alp_vp_jozz.uiStates

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

data class AuthenticationUIState(
    val showPassword: Boolean = false,
    val passwordVisibility: VisualTransformation = PasswordVisualTransformation(),
    val buttonEnabled: Boolean = false
)