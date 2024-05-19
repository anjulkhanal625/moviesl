package com.anjul.exercise.kittipay.ui.detail

import android.os.Bundle
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.core.BaseViewModelActivity
import com.anjul.exercise.kittipay.databinding.ActivityMovieDetailBinding

class MovieDetailActivity :
    BaseViewModelActivity<ActivityMovieDetailBinding, MovieDetailViewModel>() {


    override fun getViewModelClass(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun getLayout(): Int = R.layout.activity_movie_detail
    private fun initViews() {
    }

    override fun onCreateViewModel(savedInstanceState: Bundle?) {
        val movieId: Int? = intent?.getIntExtra("movieId", 0)
        binding.viewModel = viewModel
        initViews()
        viewModel.getMovieDetail(movieId)
        initObserver()
    }

    private fun initObserver() {
//        viewModel.moviesDetails.

    }


}