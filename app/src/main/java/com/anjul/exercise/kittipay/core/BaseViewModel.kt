package com.anjul.exercise.kittipay.core

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.anjul.exercise.kittipay.enums.Status
import com.anjul.exercise.kittipay.extensions.isNetworkConnected
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val job by lazy {
        SupervisorJob()
    }
    var loading: ObservableField<Boolean> = ObservableField(true)
    var status: MutableLiveData<Status> = MutableLiveData(Status.LOADING)
    val viewModelScope = CoroutineScope(Dispatchers.Main + job)


    fun hasInternetConnection(context: Context): Boolean {
        val networkConnected = context.isNetworkConnected()
        if (networkConnected.not()) status.value = Status.NO_INTERNET
        return networkConnected
    }

}