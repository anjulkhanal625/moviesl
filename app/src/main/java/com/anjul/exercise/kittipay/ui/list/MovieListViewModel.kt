package com.anjul.exercise.kittipay.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anjul.exercise.kittipay.core.BaseViewModel
import com.anjul.exercise.kittipay.rest.response.Movie
import com.compass_group.compis_b2b.network.ApiService
import kotlinx.coroutines.launch

class MovieListViewModel(application: Application) : BaseViewModel(application) {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies
    var repo: TmdbRepositoryContract


    init {
        repo = TmdbRepository(application)
    }


    fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                repo.fetchPopularMovies().collect{
                Log.d("test","fetchPopularMoviesCollect ")
                }


            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }


}