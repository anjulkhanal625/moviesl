package com.compass_group.compis_b2b.network

import com.anjul.exercise.kittipay.rest.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): MovieResponse


}