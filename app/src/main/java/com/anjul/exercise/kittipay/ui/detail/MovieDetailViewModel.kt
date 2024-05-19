package com.anjul.exercise.kittipay.ui.detail

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import com.anjul.exercise.kittipay.core.BaseViewModel
import com.anjul.exercise.kittipay.rest.response.MovieDetails
import com.anjul.exercise.kittipay.ui.list.MoviesRepository
import com.anjul.exercise.kittipay.ui.list.MoviesRepositoryContract
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : BaseViewModel(application) {
    var repo: MoviesRepositoryContract
    var moviesDetails: ObservableField<MovieDetails?> = ObservableField()
    init {
        repo = MoviesRepository(application)

    }

    fun getMovieDetail(movieId: Int?) {
        Log.d("MovieId ", "movieId is ${movieId}")
        viewModelScope.launch {
            if (movieId != 0) {
                repo.fetchMovieDetail(movieId!!).collect {
                    moviesDetails.set(it)
                }
            }

        }




    }
}