//package com.example.alp_vp_jozz.viewModels
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.graphics.Color
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.navigation.NavHostController
//import com.example.alp_vp_jozz.enums.PagesEnum
//import com.example.alp_vp_jozz.enums.PrioritiesEnum
//import com.example.alp_vp_jozz.models.GeneralResponseModel
//import com.example.alp_vp_jozz.models.UserResponse
//import com.example.alp_vp_jozz.repositories.UserRepository
//import com.example.alp_vp_jozz.uiStates.StringDataStatusUIState
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import okio.IOException
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class HomeViewModel(private val userRepository: UserRepository) : ViewModel() {
//    private val _todoModel = MutableStateFlow<MutableList<TodoModel>>(mutableListOf())
//
//    val todoModel: StateFlow<List<TodoModel>>
//        get() {
//            return _todoModel.asStateFlow()
//        }
//
//    var logoutStatus: StringDataStatusUIState by mutableStateOf(StringDataStatusUIState.Start)
//        private set
//
//    init {
//        _todoModel.value.add(
//            TodoModel(
//                title = "hello world",
//                description = "alskdjfk;ashdpfuihqwpeiuhf",
//                priority = PrioritiesEnum.High,
//                dueDate = "12 October 2022",
//                status = "On Going"
//            )
//        )
//    }
//
//    fun changePriorityTextBackgroundColor(
//        priority: PrioritiesEnum
//    ): Color {
//        if (priority == PrioritiesEnum.High) {
//            return Color.Red
//        } else if (priority == PrioritiesEnum.Medium) {
//            return Color.Yellow
//        }
//
//        return Color.Green
//    }
//
//    fun logoutUser(token : String, navController: NavHostController) {
//        viewModelScope.launch {
//            logoutStatus = StringDataStatusUIState.Loading
//
//            try {
//                val call = userRepository.logout(token)
////                dataStatus = UserDataStatusUIState.Success(registerResult)
//
//                call.enqueue(object : Callback<GeneralResponseModel> {
//                    override fun onResponse(
//                        call: Call<GeneralResponseModel>,
//                        res: Response<GeneralResponseModel>
//                    ) {
//                        if (res.isSuccessful) {
//                            logoutStatus = StringDataStatusUIState.Success(res.body()!!.data)
//
//                            viewModelScope.launch {
//                                userRepository.saveUserToken("Unknown")
//                                userRepository.saveUsername("Unknown")
//                            }
//
//                            navController.navigate(PagesEnum.Login.name) {
//                                popUpTo(PagesEnum.Home.name) {
//                                    inclusive = true
//                                }
//                            }
//                        }
//                    }
//
//                    override fun onFailure(p0: Call<GeneralResponseModel>, p1: Throwable) {
//                        TODO("Not yet implemented")
//                    }
//                })
//            } catch (error: IOException) {
//
//            }
//        }
//    }
//}