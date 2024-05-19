package com.anjul.exercise.kittipay.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anjul.exercise.kittipay.core.BaseViewModel
import com.anjul.exercise.kittipay.rest.response.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(application: Application) : BaseViewModel(application) {

    val movies = MutableLiveData<List<Movie>>()
    var repo: TmdbRepositoryContract

    init {
        repo = MoviesRepository(application)
    }


    fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                repo.fetchPopularMovies().collect{
                    movies.value = it.results
                Log.d("test","fetchPopularMoviesCollect ")
                }


            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }


}