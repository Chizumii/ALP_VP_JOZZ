package com.example.alp_vp_jozz.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_vp_jozz.models.TournamentModel
import com.example.alp_vp_jozz.models.createTournament
import com.example.alp_vp_jozz.repositories.TournamentRepository
import kotlinx.coroutines.launch

class TournamentViewModel(
    private val repository: TournamentRepository // Repository untuk komunikasi dengan data layer
) : ViewModel() {

    // LiveData untuk daftar tournament
    private val _tournamentList = MutableLiveData<List<TournamentModel>>()
    val tournamentList: LiveData<List<TournamentModel>> get() = _tournamentList

    // LiveData untuk status operasi
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> get() = _status

    // LiveData untuk loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    // LiveData untuk menangani error
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    // Fungsi untuk mengambil semua tournament
    fun fetchAllTournaments() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getAllTournaments()
                _tournamentList.value = response.data ?: emptyList()
                _status.value = "Data retrieved successfully"
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "An unknown error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Fungsi untuk menambahkan tournament baru
    fun createTournament(tournament: createTournament) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.addTournament(tournament)
                if (response.success) {
                    _status.value = "Tournament created successfully"
                    fetchAllTournaments() // Refresh daftar tournament
                } else {
                    _errorMessage.value = response.message ?: "Failed to create tournament"
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "An unknown error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Fungsi untuk mereset error message
    fun resetErrorMessage() {
        _errorMessage.value = null
    }
}
