package com.anjul.exercise.kittipay.rest.response

import com.anjul.exercise.kittipay.extensions.toHoursAndMinutesString
import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("backdrop_path") val backdropPath: String,
    val title: String,
    val overview: String,
    val runtime: Int,
    @SerializedName("release_date") val releaseDate: String,

    ) {
    var runtimeString: String
        set(value) {
            value
        }
        get() {
            return runtime.toHoursAndMinutesString()
        }
}
