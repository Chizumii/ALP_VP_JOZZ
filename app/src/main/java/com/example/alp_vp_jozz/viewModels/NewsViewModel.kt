package com.example.alp_vp_jozz.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.example.alp_vp_jozz.EshypeApplication
import com.example.alp_vp_jozz.models.BeritaResponse
import com.example.alp_vp_jozz.models.CreateBerita
import com.example.alp_vp_jozz.repositories.BeritaRepository
import com.example.alp_vp_jozz.uiStates.NewsDataStatusUIState
import com.example.alp_vp_jozz.uiStates.StringDataStatusUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class NewsViewModel(
    private val beritaRepository: BeritaRepository
) : ViewModel() {

    // Data status for fetching and creating news
    var dataStatus: NewsDataStatusUIState by mutableStateOf(NewsDataStatusUIState.Start)
        private set

    // Status for submission (e.g., creating news)
    var submissionStatus: StringDataStatusUIState by mutableStateOf(StringDataStatusUIState.Start)
        private set

    // Inputs for creating news
    var titleInput by mutableStateOf("")
    var descriptionInput by mutableStateOf("")
    var imageInput by mutableStateOf("")
    var authorInput by mutableStateOf("")

    private val _news = MutableStateFlow<MutableList<BeritaResponse>>(mutableListOf())

    val news: StateFlow<List<BeritaResponse>>
        get() = _news.asStateFlow()

    // Companion object for ViewModel factory
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as EshypeApplication)
                val beritaRepository = application.container.beritaRepository
                NewsViewModel(beritaRepository)
            }
        }
    }

    // Updating input fields for news creation
    fun updateTitleInput(input: String) {
        titleInput = input
    }

    fun updateDescriptionInput(input: String) {
        descriptionInput = input
    }

    fun updateImageInput(input: String) {
        imageInput = input
    }

    fun updateAuthorInput(input: String) {
        authorInput = input
    }

    // Fetching all news
    fun fetchAllNews() {
        viewModelScope.launch {
            dataStatus = NewsDataStatusUIState.Loading
            try {
                // Call the suspend function from the repository
                val result = beritaRepository.getAllBerita()

                // Check if the result is successful or not
                if (result.isSuccess) {
                    // Safely handle the result and log for debugging
                    val newsList = result.getOrDefault(emptyList()) // Default to empty list on failure
                    _news.value = newsList // Assign directly as List<BeritaResponse>
                    dataStatus = NewsDataStatusUIState.Success
                    Log.d("NewsViewModel", "Fetched news: ${newsList.size} items.")
                } else {
                    // Log error message
                    val errorMessage = result.exceptionOrNull()?.message ?: "Unknown error"
                    Log.e("NewsViewModel", "Failed to fetch news: $errorMessage")
                    dataStatus = NewsDataStatusUIState.Error("Failed to fetch news: $errorMessage")
                }
            } catch (e: Exception) {
                // Log the exception for debugging
                Log.e("NewsViewModel", "Network error: ${e.message}", e)
                dataStatus = NewsDataStatusUIState.Error("Network error: ${e.message}")
            }
        }
    }



    // Creating news
    fun createNews(
        navController: NavController,
        titleInput1: String,
        descriptionInput1: String,
        authorInput1: String,
        imageInput1: String
    ) {
        viewModelScope.launch {
            submissionStatus = StringDataStatusUIState.Loading
            val newNews = CreateBerita(
                title = titleInput,
                description = descriptionInput,
                author = authorInput,
                image = imageInput
            )

            try {
                val result = beritaRepository.createBerita(newNews)

                if (result.isSuccess) {
                    navController.navigate("home_screen_route") // Adjust to your navigation route
                    submissionStatus = StringDataStatusUIState.Success("News created successfully")
                } else {
                    submissionStatus = StringDataStatusUIState.Failed("Failed to create news: ${result.exceptionOrNull()?.message}")
                }
            } catch (error: IOException) {
                submissionStatus = StringDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }
}
