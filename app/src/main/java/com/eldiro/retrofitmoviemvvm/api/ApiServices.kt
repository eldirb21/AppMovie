package com.eldiro.retrofitmoviemvvm.api

import com.eldiro.retrofitmoviemvvm.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by macpro on 24/01/24.
 */
interface ApiServices {

    @GET("movies/popular")
   suspend fun getPopularMovie(
        @Query("api_key") key: String?,
        @Query("page") page:Int?
    ) : MovieResponse
}