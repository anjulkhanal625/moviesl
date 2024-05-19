package com.anjul.exercise.kittipay.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.rest.response.Movie
import com.bumptech.glide.Glide

//import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies: List<Movie> = listOf()
    private var clickListner: ((Movie, ImageView, TextView) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun submitList(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    fun setClickListner(listner: ((Movie, ImageView, TextView) -> Unit)?) {
        clickListner = listner
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
//        private val overviewTextView: TextView = itemView.findViewById(R.id.overviewTextView)
        private val posterImageView: ImageView = itemView.findViewById(R.id.posterImageView)
        private val parentView: LinearLayout = itemView.findViewById(R.id.parent)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
//            overviewTextView.text = movie.overview
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
                .into(posterImageView)
            parentView.setOnClickListener {
                clickListner?.invoke(movie, posterImageView, titleTextView)
            }
        }
    }
}
