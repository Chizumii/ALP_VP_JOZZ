package com.example.alp_vp_jozz.repositories

import com.example.alp_vp_jozz.models.BeritaModel
import retrofit2.Call
import retrofit2.http.*

interface BeritaRepository {

    @GET("news")
    fun getAllBerita(): Call<List<BeritaModel>>

    @POST("news")
    fun createBerita(@Body berita: BeritaModel): Call<BeritaModel>

    @DELETE("news/{id}")
    fun deleteBerita(@Path("id") id: Int): Call<Boolean>
}
