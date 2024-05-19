package com.anjul.exercise.kittipay.ui.detail

import android.app.Application
import android.content.Intent
import androidx.databinding.ObservableField
import com.anjul.exercise.kittipay.core.BaseViewModel
import com.anjul.exercise.kittipay.enums.Status
import com.anjul.exercise.kittipay.rest.response.MovieDetails
import com.anjul.exercise.kittipay.ui.list.MoviesRepository
import com.anjul.exercise.kittipay.ui.list.MoviesRepositoryContract
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : BaseViewModel(application) {
    var repo: MoviesRepositoryContract
    var moviesDetails: ObservableField<MovieDetails?> = ObservableField()
    var movieTitle: ObservableField<String> = ObservableField()
    var placeholderImage: ObservableField<String> = ObservableField()

    init {
        repo = MoviesRepository(application)

    }

    private fun getMovieDetail(movieId: Int?) {
        viewModelScope.launch {
            if(hasInternetConnection(getApplication())){
                if (movieId != 0) {
                    repo.fetchMovieDetail(movieId!!).collect {
                        moviesDetails.set(it)
                        status.value= Status.OK
                        loading.set(false)
                    }
                }
            }


        }




    }

    fun loadExtras(intent: Intent?) {
        intent?.let {
            with(it) {
                val movieId: Int? = getIntExtra("movieId", 0)
                val image: String? = getStringExtra("placeholderImage")
                val title: String? = getStringExtra("title")
                placeholderImage.set(image)
                movieTitle.set(title)
                getMovieDetail(movieId)
            }


        }

    }
}