package com.example.alp_vp_jozz


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.alp_vp_jozz.repositories.AuthenticationRepository
import com.example.alp_vp_jozz.repositories.NetworkAuthenticationRepository
import com.example.alp_vp_jozz.services.AuthenticationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer{
    val authenticationRepository: AuthenticationRepository
}

class DefaultAppContainer(
    private val userDataStore: DataStore<Preferences>
): AppContainer{
    private val APIBaseURL = "http://192.168.50.69:3000/"

    private val authenticationRetrofitService: AuthenticationService by lazy {
        val retrofit = initRetrofit()

        retrofit.create(AuthenticationService::class.java)
    }

    override val authenticationRepository: AuthenticationRepository by lazy {
        NetworkAuthenticationRepository(authenticationRetrofitService)
    }

    private fun initRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)



        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .baseUrl(APIBaseURL)
            .build()
    }

}