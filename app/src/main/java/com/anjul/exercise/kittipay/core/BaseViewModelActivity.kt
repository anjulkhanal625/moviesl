package com.anjul.exercise.kittipay.core
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity<B>() {
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
        onCreateViewModel(savedInstanceState)


    }

    abstract fun getViewModelClass(): Class<VM>

}