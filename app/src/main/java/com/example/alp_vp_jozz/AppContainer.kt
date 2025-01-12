package com.example.alp_vp_jozz

import androidx.datastore.core.DataStore
import com.example.alp_vp_jozz.repositories.NetworkTournamentRepository
import com.example.alp_vp_jozz.repositories.TournamentRepository
import com.example.alp_vp_jozz.services.TournamentServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val tournamentRepository: TournamentRepository
}

class DefaultAppContainer(
    private val userDataStore: DataStore<androidx.datastore.preferences.core.Preferences>
) : AppContainer {
    // change it to your own local ip please
    private val baseUrl = "http://192.168.88.201:3000/"

    private val tournamentRetrofitService: TournamentServiceApi by lazy {
        val retrofit = initRetrofit()
        retrofit.create(TournamentServiceApi::class.java)
    }

    override val tournamentRepository: TournamentRepository by lazy {
        NetworkTournamentRepository(tournamentRetrofitService)
    }

    private fun initRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        return Retrofit
            .Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(client.build())
            .baseUrl(baseUrl)
            .build()
    }


}

