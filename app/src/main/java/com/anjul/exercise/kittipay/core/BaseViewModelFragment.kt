package com.anjul.exercise.kittipay.core

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider;

abstract class BaseViewModelFragment<B : ViewDataBinding, VM : BaseViewModel> : BaseFragment<B>() {
    protected lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClass())


        onViewReady(view, savedInstanceState)
    }

    abstract fun onViewReady(view: View, savedInstanceState: Bundle?)
    abstract fun getViewModelClass(): Class<VM>

}