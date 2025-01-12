package com.example.alp_vp_jozz.services

import com.example.alp_vp_jozz.models.BeritaResponse
import com.example.alp_vp_jozz.models.CreateBerita
import com.example.alp_vp_jozz.models.UpdateBerita
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BeritaApiService {
    // Get all news
    @GET("news")
    suspend fun getAllBerita(): Response<List<BeritaResponse>>

    // Create news
    @POST("news")
    suspend fun createBerita(@Body berita: CreateBerita): Response<BeritaResponse>

    // Update news
    @PUT("news/{id}")
    suspend fun updateBerita(@Path("id") id: Int, @Body berita: UpdateBerita): Response<BeritaResponse>

    // Delete news
    @DELETE("news/{id}")
    suspend fun deleteBerita(@Path("id") id: Int): Response<Unit>
}

object BeritaService {

    private const val BASE_URL = "http://192.168.56.69:3000/" // Ganti dengan URL API Anda

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
