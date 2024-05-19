package com.anjul.exercise.kittipay.core.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.anjul.exercise.kittipay.rest.ApiService
import com.anjul.exercise.kittipay.rest.RetrofitInstance

open class BaseRepository(val application: Application) {

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