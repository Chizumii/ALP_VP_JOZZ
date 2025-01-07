package com.example.alp_vp_jozz.repositories

// repository/UserRepository.kt
// data/repository/UserRepository.kt
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.alp_vp_jozz.models.ApiResponse
import com.example.alp_vp_jozz.models.GeneralResponseModel
import com.example.alp_vp_jozz.models.LoginUserRequest
import com.example.alp_vp_jozz.models.RegisterUserRequest
import com.example.alp_vp_jozz.models.UpdateUserRequest
import com.example.alp_vp_jozz.models.UserResponse
import com.example.alp_vp_jozz.services.RetrofitInstance
import com.example.alp_vp_jozz.services.UserServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import okhttp3.Response
import retrofit2.Call
import javax.inject.Inject

interface UserRepository {
    val currentUserToken: Flow<String>
    val currentUsername: Flow<String>

    fun logout(token: String): Call<GeneralResponseModel>

    suspend fun saveUserToken(token: String)
    suspend fun saveUsername(username: String)
}

class NetworkUserRepository(
    private val userDataStore: DataStore<Preferences>,
    private val userAPIService: UserServiceApi
) : UserRepository {
    private companion object {
        val USER_TOKEN = stringPreferencesKey("token")
        val USERNAME = stringPreferencesKey("username")
    }

    override val currentUserToken: Flow<String> =
        userDataStore.data.map { preferences -> preferences[USER_TOKEN] ?: "Unknown" }

    override val currentUsername: Flow<String> =
        userDataStore.data.map { preferences -> preferences[USERNAME] ?: "Unknown" }

    override fun logout(token: String): Call<GeneralResponseModel> {
        return userAPIService.logout(token)
    }

    override suspend fun saveUserToken(token: String) {
        userDataStore.edit { preferences ->
            preferences[USER_TOKEN] = token
        }
    }

    override suspend fun saveUsername(username: String) {
        userDataStore.edit { preferences ->
            preferences[USERNAME] = username
        }
    }
}
