package com.anjul.exercise.kittipay.rest.response

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("backdrop_path") val backdropPath: String,
    val title: String,
    val overview: String,
    val runtime: Int,
    @SerializedName("release_date") val releaseDate: String
)
