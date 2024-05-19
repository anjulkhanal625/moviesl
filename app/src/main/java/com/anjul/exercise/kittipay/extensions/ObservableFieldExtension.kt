package com.anjul.exercise.kittipay.extensions

import androidx.databinding.Observable
import androidx.databinding.ObservableField


fun <T : Any> ObservableField<T>.observeInt(callback: (Int?) -> Unit): Unit {
    this.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            val field: ObservableField<T> = sender as ObservableField<T>
            callback(field.get() as Int)
        }
    })
}