package com.anjul.exercise.kittipay.ui.list

import android.app.Application
import com.anjul.exercise.kittipay.core.base.BaseRepository
import com.anjul.exercise.kittipay.rest.ApiService
import com.anjul.exercise.kittipay.rest.response.MovieDetails
import com.anjul.exercise.kittipay.rest.response.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesRepository(application: Application) : BaseRepository(application),
    MoviesRepositoryContract {

    val TAG: String = MoviesRepository::class.java.simpleName
    private val apiService: ApiService by lazy {
        getApiService(application)
    }

    override fun fetchPopularMovies(): Flow<MovieResponse> {
        return flow {
            val response = apiService.getPopularMovies()
            emit(response)
        }
    }

    override fun fetchMovieDetail(movieId: Int): Flow<MovieDetails> {
        return flow {
            val response = apiService.getMovieDetails(movieId)
            emit(response)
        }
    }
}


interface MoviesRepositoryContract {
    fun fetchPopularMovies(): Flow<MovieResponse>
    fun fetchMovieDetail(movieId: Int): Flow<MovieDetails>

}