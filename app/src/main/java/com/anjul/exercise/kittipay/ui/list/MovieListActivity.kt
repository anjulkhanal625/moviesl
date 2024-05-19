package com.anjul.exercise.kittipay.ui.list

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.core.BaseViewModelActivity
import com.anjul.exercise.kittipay.databinding.ActivityMovieListBinding
import com.anjul.exercise.kittipay.ui.detail.MovieDetailActivity
import com.anjul.exercise.kittipay.ui.list.adapter.MovieAdapter
import android.util.Pair as UtilPair

class MovieListActivity : BaseViewModelActivity<ActivityMovieListBinding, MovieListViewModel>() {
    val movieAdapter: MovieAdapter by lazy {
        MovieAdapter()
    }

    override fun getViewModelClass(): Class<MovieListViewModel> = MovieListViewModel::class.java

    override fun getLayout(): Int = R.layout.activity_movie_list
    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter.setClickListner { movie, sharedImageView, titleTextView ->
            val intent = Intent(this@MovieListActivity, MovieDetailActivity::class.java).apply {
                putExtra("movieId", movie.id)
                putExtra("placeholderImage", movie.poster_path)
                putExtra("title", movie.title)
            }


            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                UtilPair.create(sharedImageView, "banner"),
                UtilPair.create(titleTextView, "title")
            )
            // Start the new activity
            startActivity(intent, options.toBundle())
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