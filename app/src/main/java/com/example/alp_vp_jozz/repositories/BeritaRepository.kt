package com.example.alp_vp_jozz.repositories

import com.example.alp_vp_jozz.models.BeritaModel
import retrofit2.Response
import retrofit2.http.*

interface BeritaApiService {
    @GET("news")
    suspend fun getAllBerita(): Response<List<BeritaModel>>

    @POST("news")
    suspend fun createBerita(@Body berita: BeritaModel): Response<BeritaModel>

    @PUT("news/{id}")
    suspend fun updateBerita(@Path("id") id: Int, @Body berita: BeritaModel): Response<BeritaModel>

    @DELETE("news/{id}")
    suspend fun deleteBerita(@Path("id") id: Int): Response<Unit>
}


class BeritaRepository(private val apiService: BeritaApiService) {

    // Fetch all news
    suspend fun getAllBerita(): Result<List<BeritaModel>> {
        return try {
            val response = apiService.getAllBerita()
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Failed to fetch news: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Create news
    suspend fun createBerita(berita: BeritaModel): Result<BeritaModel> {
        return try {
            val response = apiService.createBerita(berita)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to create news: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Update news
    suspend fun updateBerita(id: Int, berita: BeritaModel): Result<BeritaModel> {
        return try {
            val response = apiService.updateBerita(id, berita)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to update news: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Delete news
    suspend fun deleteBerita(id: Int): Result<Unit> {
        return try {
            val response = apiService.deleteBerita(id)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Failed to delete news: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

