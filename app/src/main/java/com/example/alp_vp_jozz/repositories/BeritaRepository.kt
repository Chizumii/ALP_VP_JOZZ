package com.example.alp_vp_jozz.repositories

import android.util.Log
import com.example.alp_vp_jozz.models.BeritaResponse
import com.example.alp_vp_jozz.models.CreateBerita
import com.example.alp_vp_jozz.models.UpdateBerita
import com.example.alp_vp_jozz.services.BeritaApiService
import retrofit2.Response

class BeritaRepository(private val apiService: BeritaApiService) {

    // Fetch all news
    suspend fun getAllBerita(): Result<List<BeritaResponse>> {
        return try {
            // Call the API
            val response = apiService.getAllBerita()

            if (response.isSuccessful) {
                // Log response for debugging
                Log.d("BeritaRepository", "Successfully fetched news: ${response.body()?.size} items.")
                Result.success(response.body() ?: emptyList())
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                // Log failure
                Log.e("BeritaRepository", "Failed to fetch news: $errorMessage")
                Result.failure(Exception("Failed to fetch news: $errorMessage"))
            }
        } catch (e: Exception) {
            // Log exception if any
            Log.e("BeritaRepository", "Error during fetching news: ${e.message}", e)
            Result.failure(e)
        }
    }



    // Create news
    suspend fun createBerita(berita: CreateBerita): Result<BeritaResponse> {
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
    suspend fun updateBerita(id: Int, berita: UpdateBerita): Result<BeritaResponse> {
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
