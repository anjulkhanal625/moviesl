package com.anjul.exercise.kittipay.ui.detail

import android.app.Application
import android.util.Log
import com.anjul.exercise.kittipay.core.BaseViewModel
import com.anjul.exercise.kittipay.ui.list.MoviesRepository
import com.anjul.exercise.kittipay.ui.list.MoviesRepositoryContract

class MovieDetailViewModel(application: Application) : BaseViewModel(application) {
    var repo: MoviesRepositoryContract

    init {
        repo = MoviesRepository(application)

    }
    fun getMovieDetail(movieId: Int?) {
        Log.d("MovieId ", "movieId is ${movieId}")
    }
}