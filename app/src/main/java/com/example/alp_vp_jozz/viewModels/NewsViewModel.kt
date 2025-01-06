package com.example.alp_vp_jozz.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_vp_jozz.models.BeritaModel
import com.example.alp_vp_jozz.repositories.BeritaRepository
import com.example.alp_vp_jozz.uiStates.StringDataStatusUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(private val beritaRepository: BeritaRepository) : ViewModel() {

    private val _newsList = MutableStateFlow<List<BeritaModel>>(emptyList())
    val newsList: StateFlow<List<BeritaModel>>
        get() = _newsList.asStateFlow()

    var newsStatus: StringDataStatusUIState by mutableStateOf(StringDataStatusUIState.Start)
        private set

    // Mendapatkan semua berita
    fun fetchAllNews() {
        viewModelScope.launch {
            newsStatus = StringDataStatusUIState.Loading

            try {
                val call = beritaRepository.getAllBerita()
                call.enqueue(object : Callback<List<BeritaModel>> {
                    override fun onResponse(
                        call: Call<List<BeritaModel>>,
                        response: Response<List<BeritaModel>>
                    ) {
                        if (response.isSuccessful) {
                            _newsList.value = response.body() ?: emptyList()
                            newsStatus = StringDataStatusUIState.Success("News fetched successfully")
                        } else {
                            newsStatus = StringDataStatusUIState.Error("Failed to fetch news")
                        }
                    }

                    override fun onFailure(call: Call<List<BeritaModel>>, t: Throwable) {
                        newsStatus = StringDataStatusUIState.Error(t.message ?: "Unknown error")
                    }
                })
            } catch (error: IOException) {
                newsStatus = StringDataStatusUIState.Error("Network error")
            }
        }
    }

    // Membuat berita baru
    fun createNews(newNews: BeritaModel) {
        viewModelScope.launch {
            newsStatus = StringDataStatusUIState.Loading

            try {
                val call = beritaRepository.createBerita(newNews)
                call.enqueue(object : Callback<BeritaModel> {
                    override fun onResponse(
                        call: Call<BeritaModel>,
                        response: Response<BeritaModel>
                    ) {
                        if (response.isSuccessful) {
                            fetchAllNews() // Refresh list
                            newsStatus = StringDataStatusUIState.Success("News created successfully")
                        } else {
                            newsStatus = StringDataStatusUIState.Error("Failed to create news")
                        }
                    }

                    override fun onFailure(call: Call<BeritaModel>, t: Throwable) {
                        newsStatus = StringDataStatusUIState.Error(t.message ?: "Unknown error")
                    }
                })
            } catch (error: IOException) {
                newsStatus = StringDataStatusUIState.Error("Network error")
            }
        }
    }

    // Menghapus berita berdasarkan ID
    fun deleteNews(id: Int) {
        viewModelScope.launch {
            newsStatus = StringDataStatusUIState.Loading

            try {
                val call = beritaRepository.deleteBerita(id)
                call.enqueue(object : Callback<Boolean> {
                    override fun onResponse(
                        call: Call<Boolean>,
                        response: Response<Boolean>
                    ) {
                        if (response.isSuccessful && response.body() == true) {
                            fetchAllNews() // Refresh list
                            newsStatus = StringDataStatusUIState.Success("News deleted successfully")
                        } else {
                            newsStatus = StringDataStatusUIState.Error("Failed to delete news")
                        }
                    }

                    override fun onFailure(call: Call<Boolean>, t: Throwable) {
                        newsStatus = StringDataStatusUIState.Error(t.message ?: "Unknown error")
                    }
                })
            } catch (error: IOException) {
                newsStatus = StringDataStatusUIState.Error("Network error")
            }
        }
    }
}
