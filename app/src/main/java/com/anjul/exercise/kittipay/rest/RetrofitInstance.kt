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


    fun getApiService(): ApiService {
        val retrofit = Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
            .baseUrl("https://api.themoviedb.org/3/movie/")
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
            .connectTimeout(TIMEOUT,SECONDS)
            .readTimeout(TIMEOUT, SECONDS)
            .writeTimeout(TIMEOUT, SECONDS)
            .build()
    }


}