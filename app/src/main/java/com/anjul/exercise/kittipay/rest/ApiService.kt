package  com.anjul.exercise.kittipay.rest

import com.anjul.exercise.kittipay.rest.response.MovieDetails
import com.anjul.exercise.kittipay.rest.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
    ): MovieDetails


}