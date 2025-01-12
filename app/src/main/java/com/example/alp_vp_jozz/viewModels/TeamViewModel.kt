package com.example.alp_vp_jozz.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_vp_jozz.models.CreateTeamRequest
import com.example.alp_vp_jozz.models.TeamResponse
import com.example.alp_vp_jozz.repositories.TeamRepository
import kotlinx.coroutines.launch

class TeamViewModel(private val repository: TeamRepository) : ViewModel() {

    private val _teamResponse = MutableLiveData<TeamResponse>()
    val teamResponse: LiveData<TeamResponse> = _teamResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun createTeam(request: CreateTeamRequest) {
        viewModelScope.launch {
            try {
                val response = repository.createTeam(request).execute()
                if (response.isSuccessful) {
                    _teamResponse.value = response.body()
                } else {
                    _errorMessage.value = "Failed to create team: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun fetchTeam(teamID: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getTeam(teamID)
                if (response.isSuccessful) {
                    _teamResponse.value = response.body()
                } else {
                    _errorMessage.value = "Failed to fetch team: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }
}
