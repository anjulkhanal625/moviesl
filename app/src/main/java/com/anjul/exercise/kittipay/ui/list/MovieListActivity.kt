package com.anjul.exercise.kittipay.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.core.BaseViewModelActivity
import com.anjul.exercise.kittipay.databinding.ActivityMovieListBinding
import com.anjul.exercise.kittipay.ui.detail.MovieDetailActivity
import com.anjul.exercise.kittipay.ui.list.adapter.MovieAdapter

class MovieListActivity : BaseViewModelActivity<ActivityMovieListBinding, MovieListViewModel>() {
    val movieAdapter: MovieAdapter by lazy {
        MovieAdapter()
    }

    override fun getViewModelClass(): Class<MovieListViewModel> = MovieListViewModel::class.java

    override fun getLayout(): Int = R.layout.activity_movie_list
    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter.setClickListner { movieId ->
            val intent = Intent(this@MovieListActivity, MovieDetailActivity::class.java).apply {
                putExtra("movieId", movieId)
            }
            startActivity(intent)
        }
        binding.recyclerView.adapter = movieAdapter

    }
    override fun onCreateViewModel(savedInstanceState: Bundle?) {
        initViews()
        initObserver()
        viewModel.fetchPopularMovies()
    }

    private fun initObserver() {
        viewModel.movies.observe(this, Observer { it ->
            movieAdapter.submitList(it)
        })
    }
}