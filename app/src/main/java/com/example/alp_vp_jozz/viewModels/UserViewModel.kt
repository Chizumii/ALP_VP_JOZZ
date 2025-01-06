package com.example.alp_vp_jozz.viewModels

// viewmodel/UserViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_vp_jozz.models.LoginUserRequest
import com.example.alp_vp_jozz.models.RegisterUserRequest
import com.example.alp_vp_jozz.models.UpdateUserRequest
import com.example.alp_vp_jozz.models.UserResponse
import com.example.alp_vp_jozz.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    // Registration
    private val _registerState = MutableStateFlow<Result<UserResponse>?>(null)
    val registerState: StateFlow<Result<UserResponse>?> = _registerState

    fun registerUser(request: RegisterUserRequest) {
        viewModelScope.launch {
            val result = repository.registerUser(request)
            _registerState.value = result
        }
    }

    // Login
    private val _loginState = MutableStateFlow<Result<UserResponse>?>(null)
    val loginState: StateFlow<Result<UserResponse>?> = _loginState

    fun loginUser(request: LoginUserRequest) {
        viewModelScope.launch {
            val result = repository.loginUser(request)
            _loginState.value = result
        }
    }

    // Update User
    private val _updateState = MutableStateFlow<Result<UserResponse>?>(null)
    val updateState: StateFlow<Result<UserResponse>?> = _updateState

    fun updateUser(userId: String, request: UpdateUserRequest, token: String) {
        viewModelScope.launch {
            val result = repository.updateUser(userId, request, token)
            _updateState.value = result
        }
    }

    // Logout
    private val _logoutState = MutableStateFlow<Result<String>?>(null)
    val logoutState: StateFlow<Result<String>?> = _logoutState

    fun logoutUser(token: String) {
        viewModelScope.launch {
            val result = repository.logoutUser(token)
            _logoutState.value = result
        }
    }
}
