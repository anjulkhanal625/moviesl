package com.anjul.exercise.kittipay.core

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val job by lazy {
        SupervisorJob()
    }
    var loading: ObservableField<Boolean> = ObservableField(true)
    val viewModelScope = CoroutineScope(Dispatchers.Main + job)

}