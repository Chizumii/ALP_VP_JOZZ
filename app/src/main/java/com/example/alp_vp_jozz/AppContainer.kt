package com.example.alp_vp_jozz

import androidx.datastore.core.DataStore
import com.example.alp_vp_jozz.repositories.BeritaRepository
import com.example.alp_vp_jozz.repositories.NetworkTournamentRepository
import com.example.alp_vp_jozz.repositories.TournamentRepository
import com.example.alp_vp_jozz.services.BeritaApiService
import com.example.alp_vp_jozz.services.TournamentServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val tournamentRepository: TournamentRepository
    val beritaRepository: BeritaRepository // Add beritaRepository to the container
}

class DefaultAppContainer(
    private val userDataStore: DataStore<androidx.datastore.preferences.core.Preferences>
) : AppContainer {
    // Base URLs for both services
    private val baseUrl = "http://192.168.56.69:3000/" // Your API base URL

    // Initialize Retrofit services for Tournament and Berita
    private val tournamentRetrofitService: TournamentServiceApi by lazy {
        val retrofit = initRetrofit()
        retrofit.create(TournamentServiceApi::class.java)
    }

    private val beritaRetrofitService: BeritaApiService by lazy { // Add Berita API service
        val retrofit = initRetrofit()
        retrofit.create(BeritaApiService::class.java)
    }

    // Lazy initialization for repositories
    override val tournamentRepository: TournamentRepository by lazy {
        NetworkTournamentRepository(tournamentRetrofitService)
    }

    override val beritaRepository: BeritaRepository by lazy { // Add Berita Repository
        BeritaRepository(beritaRetrofitService)
    }

    // Initialize Retrofit with logging for debugging
    private fun initRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .baseUrl(baseUrl)
            .build()
    }
}


