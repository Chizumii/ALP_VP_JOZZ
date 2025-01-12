package com.example.alp_vp_jozz.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.example.alp_vp_jozz.EshypeApplication
import com.example.alp_vp_jozz.models.GeneralResponseModel
import com.example.alp_vp_jozz.models.BeritaModel
import com.example.alp_vp_jozz.repositories.BeritaRepository
import com.example.alp_vp_jozz.uiStates.NewsDataStatusUIState
import com.example.alp_vp_jozz.uiStates.StringDataStatusUIState
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.resume

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

    private val _news = MutableStateFlow<MutableList<BeritaModel>>(mutableListOf())

    val news: StateFlow<List<BeritaModel>>
        get() {
            return _news.asStateFlow()
        }

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
                val response = beritaRepository.getAllBerita().execute()
                if (response.isSuccessful) {
                    _news.value = response.body() ?: mutableListOf()
                    dataStatus = NewsDataStatusUIState.Success
                } else {
                    dataStatus = NewsDataStatusUIState.Error("Failed to fetch news: ${response.message()}")
                }
            } catch (e: Exception) {
                dataStatus = NewsDataStatusUIState.Error("Network error: ${e.message}")
            }
        }
    }

    // Creating news
    fun createNews(navController: NavController) {
        viewModelScope.launch {
            submissionStatus = StringDataStatusUIState.Loading
            val newNews = BeritaModel(
                title = titleInput,
                description = descriptionInput,
                author = authorInput,
                image = imageInput
            )

            try {
                val call = beritaRepository.createBerita(newNews)

                val response = suspendCancellableCoroutine { continuation ->
                    call.enqueue(object : Callback<GeneralResponseModel> {
                        override fun onResponse(
                            call: Call<GeneralResponseModel>,
                            response: Response<GeneralResponseModel>
                        ) {
                            continuation.resume(response)
                        }

                        override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                            submissionStatus = StringDataStatusUIState.Failed(t.localizedMessage)
                        }
                    })
                    continuation.invokeOnCancellation {
                        call.cancel()
                    }
                }

                if (response.isSuccessful) {
                    navController.navigate("home_screen_route") // Adjust to your navigation route
                    submissionStatus = StringDataStatusUIState.Success("News created successfully")
                } else {
                    submissionStatus = StringDataStatusUIState.Failed("Failed to create news")
                }
            } catch (error: IOException) {
                submissionStatus = StringDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }
}
