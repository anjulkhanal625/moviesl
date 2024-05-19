package com.anjul.exercise.kittipay.ui.list

import android.app.Application
import com.anjul.exercise.kittipay.core.base.BaseRepository
import com.anjul.exercise.kittipay.rest.response.MovieResponse
import com.compass_group.compis_b2b.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TmdbRepository(application: Application) : BaseRepository(application),
    TmdbRepositoryContract {

    val TAG: String = TmdbRepository::class.java.simpleName
    private val apiService: ApiService by lazy {
        getApiService(application)
    }

    override fun fetchPopularMovies(): Flow<MovieResponse> {
        return flow {
            val response = apiService.getPopularMovies(API_KEY)
            emit(response)
        }
    }
}


interface TmdbRepositoryContract {
    fun fetchPopularMovies(): Flow<MovieResponse>
}