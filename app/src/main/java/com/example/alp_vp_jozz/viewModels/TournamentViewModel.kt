package com.example.alp_vp_jozz.viewmodels

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
import androidx.navigation.NavHostController
import com.example.alp_vp_jozz.EshypeApplication
import com.example.alp_vp_jozz.enums.PagesEnum
import com.example.alp_vp_jozz.models.ErrorModel
import com.example.alp_vp_jozz.models.GeneralResponseModel
import com.example.alp_vp_jozz.models.GetAllTournament
import com.example.alp_vp_jozz.models.TournamentResponse
import com.example.alp_vp_jozz.repositories.TournamentRepository
import com.example.alp_vp_jozz.uiStates.StringDataStatusUIState
import com.example.alp_vp_jozz.uiStates.TournamentDataStatusUIState
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class TournamentViewModel(
    private val tournamentRepository: TournamentRepository
) : ViewModel() {
    var dataStatus: TournamentDataStatusUIState by mutableStateOf(TournamentDataStatusUIState.Start)
        private set


    var submissionStatus: StringDataStatusUIState by mutableStateOf(StringDataStatusUIState.Start)
        private set

    var nameTournamentInput by mutableStateOf("")

    var descriptionInput by mutableStateOf("")

    var imageInput by mutableStateOf("")

    var typeInput by mutableStateOf("")

    var costInput by mutableStateOf("")

    var lokasiInput by mutableStateOf(0)

    fun updateNameTournamentInput(input: String) {
        nameTournamentInput = input
    }

    fun updateDescriptionInput(input: String) {
        descriptionInput = input
    }

    fun updateImageInput(input: String) {
        imageInput = input
    }

    fun updateTypeInput(input: String) {
        typeInput = input
    }

    fun updateCostInput(input: String) {
        costInput = input
    }

    fun updateLokasiInput(input: Int) {
        lokasiInput = input
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as EshypeApplication)
                val tournamentRepository = application.container.tournamentRepository
                TournamentViewModel(tournamentRepository)
            }
        }
    }

    fun createTournament(
        navController: NavHostController,
        nameTournamentInput: String,
        descriptionInput: String,
        imageInput: String,
        typeInput: String,
        costInput: String

    ) {
        viewModelScope.launch {
            try {
                val call = tournamentRepository.createTournament(
                    namaTournament = nameTournamentInput,
                    description = descriptionInput,
                    image = imageInput,
                    tipe = typeInput,
                    biaya = costInput,
                    lokasiID = lokasiInput
                )

                call.enqueue(object : Callback<GeneralResponseModel> {
                    override fun onResponse(
                        call: Call<GeneralResponseModel>,
                        res: Response<GeneralResponseModel>
                    ) {
                        if (res.isSuccessful) {
                            Log.d("json", "JSON RESPONSE: ${res.body()!!.data}")

                            navController.navigate(PagesEnum.Home.name) {
                                popUpTo(PagesEnum.Login.name) {
                                    inclusive = true
                                }
                            }
                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                ErrorModel::class.java
                            )

                        }
                    }

                    override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                        submissionStatus = StringDataStatusUIState.Failed(t.localizedMessage)
                    }

                })
            } catch (error: IOException) {
                submissionStatus = StringDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    fun getAllRestaurants(token: String) {
        viewModelScope.launch {
            try {
                val call = tournamentRepository.getALLTournament(
                    namaTournament = nameTournamentInput,
                    description = descriptionInput,
                    image = imageInput,
                    tipe = typeInput,
                    biaya = costInput,
                    lokasiID = lokasiInput
                )
                call.enqueue(object : Callback<TournamentResponse> {
                    override fun onResponse(call: Call<TournamentResponse>, res: Response<TournamentResponse>) {
                        if (res.isSuccessful) {
                            Log.d("data-result", "TODO LIST DATA: ${dataStatus}")
                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                ErrorModel::class.java
                            )

                            dataStatus = TournamentDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<TournamentResponse>, t: Throwable) {
                        dataStatus = TournamentDataStatusUIState.Failed(t.localizedMessage)
                    }

                })
            } catch (error: IOException) {
                dataStatus = TournamentDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }


}
