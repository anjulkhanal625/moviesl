package com.anjul.exercise.kittipay.ui.list

import android.os.Bundle
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.core.BaseViewModelActivity
import com.anjul.exercise.kittipay.databinding.ActivityMovieListBinding

class MovieListActivity : BaseViewModelActivity<ActivityMovieListBinding, MovieListViewModel>() {
    override fun getViewModelClass(): Class<MovieListViewModel> = MovieListViewModel::class.java

    override fun getLayout(): Int = R.layout.activity_movie_list

    override fun onCreateViewModel(savedInstanceState: Bundle?) {

    }
}