package com.anjul.exercise.kittipay.core.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.anjul.exercise.kittipay.rest.RetrofitInstance
import com.compass_group.compis_b2b.network.ApiService

open class BaseRepository(val application: Application) {

    final val API_KEY = ""
    lateinit var pref: SharedPreferences

    init {
        pref = PreferenceManager.getDefaultSharedPreferences(application)
    }

    fun getContext(): Context {
        return application.applicationContext
    }


    fun getApiService(application: Application): ApiService {
        return RetrofitInstance(application.applicationContext).getApiService()
    }
}