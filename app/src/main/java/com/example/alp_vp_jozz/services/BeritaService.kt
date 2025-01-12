package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.BeritaModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BeritaApiService {

    @GET("/api/news")
    suspend fun getAllBerita(): List<BeritaModel>

    @POST("/api/news")
    suspend fun createBerita(@Body berita: BeritaModel): BeritaModel

    @PUT("/api/news/{id}")
    suspend fun updateBerita(@Path("id") id: Int, @Body berita: BeritaModel): BeritaModel

    @DELETE("/api/news/{id}")
    suspend fun deleteBerita(@Path("id") id: Int): Boolean
}

object BeritaService {

    private const val BASE_URL = "https://your-api-url.com/" // Ganti dengan URL API Anda

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val beritaApiService: BeritaApiService by lazy {
        retrofit.create(BeritaApiService::class.java)
    }
}
