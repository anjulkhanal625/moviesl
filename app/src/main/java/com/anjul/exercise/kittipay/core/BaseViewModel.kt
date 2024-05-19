package com.anjul.exercise.kittipay.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val job by lazy {
        SupervisorJob()
    }
    val viewModelScope = CoroutineScope(Dispatchers.Main + job)

}