package com.anjul.exercise.kittipay.ui.detail

import android.os.Bundle
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.core.BaseViewModelActivity
import com.anjul.exercise.kittipay.databinding.ActivityMovieDetailBinding
import com.anjul.exercise.kittipay.view.costumview.StatusView

class MovieDetailActivity :
    BaseViewModelActivity<ActivityMovieDetailBinding, MovieDetailViewModel>() {


    override fun getViewModelClass(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun getLayout(): Int = R.layout.activity_movie_detail
    private fun initViews() {
        handleStatus(binding.statusView)
    }



    override fun onCreateViewModel(savedInstanceState: Bundle?) {
        viewModel.loadExtras(intent)
        binding.viewModel = viewModel
        initViews()
    }



}