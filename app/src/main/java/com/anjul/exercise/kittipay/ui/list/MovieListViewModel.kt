package com.anjul.exercise.kittipay.ui.list

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.anjul.exercise.kittipay.core.BaseViewModel
import com.anjul.exercise.kittipay.enums.Status
import com.anjul.exercise.kittipay.rest.response.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(application: Application) : BaseViewModel(application) {

    val movies = MutableLiveData<List<Movie>>()
    var repo: MoviesRepositoryContract

    init {
        repo = MoviesRepository(application)
    }


    fun fetchPopularMovies() {
        if (hasInternetConnection(getApplication())) {
            viewModelScope.launch {
                try {
                    repo.fetchPopularMovies().collect {
                        movies.value = it.results
                        status.value = Status.OK
                    }


                } catch (e: Exception) {
                    // Handle exceptions
                }
            }
        }

    }


}