package com.anjul.exercise.kittipay.rest

import android.content.Context
import com.anjul.exercise.kittipay.commons.DataConstant.Companion.TIMEOUT
import com.compass_group.compis_b2b.network.ApiService
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit.SECONDS
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


class RetrofitInstance(private val context: Context) {

final val bearerToken:String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNTYxNWExNDBmMDdiMmM2MzIwMzJiYzY5ZWY5ZWQzMCIsInN1YiI6IjY2NDhhMWQ2NmM1ZTY2ZmU0ZDk1YjcwNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mEc7Yja7JRq4uuu7ViQAP56x6i9nc3rLls8CU0f-mGk"
    fun getApiService(): ApiService {
        val retrofit = Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    private fun getHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", bearerToken)
                    .addHeader("accept", "application/json")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(TIMEOUT,SECONDS)
            .readTimeout(TIMEOUT, SECONDS)
            .writeTimeout(TIMEOUT, SECONDS)
            .build()
    }


}