package com.eldiro.retrofitmoviemvvm.repositories

import com.eldiro.retrofitmoviemvvm.BuildConfig
import com.eldiro.retrofitmoviemvvm.api.ApiConfig

/**
 * Created by Eldiro on 24/01/24.
 * Apakah kamu yakin ini bekerja dengan baik?
 */

//nge provide data request
class MovieRepository {
    private val client = ApiConfig.getApiService()

    suspend fun getPopularMovie(page: Int) = client.getPopularMovie(BuildConfig.API_KEY, page)
//    suspend fun searchMovie(query: String, page: Int) = client.searchMovie(BuildConfig.API_KEY, query, page)
//    suspend fun getGenres() = client.getGenres(BuildConfig.API_KEY)
}