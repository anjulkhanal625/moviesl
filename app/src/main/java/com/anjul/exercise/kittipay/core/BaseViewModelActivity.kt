package com.anjul.exercise.kittipay.core
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anjul.exercise.kittipay.view.costumview.StatusView

abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity<B>() {
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
        onCreateViewModel(savedInstanceState)
    }

    fun handleStatus(statusView: StatusView) {
        viewModel.status.observe(this, Observer { status ->
            statusView.showStatus(status)
        })
    }
    abstract fun getViewModelClass(): Class<VM>

}