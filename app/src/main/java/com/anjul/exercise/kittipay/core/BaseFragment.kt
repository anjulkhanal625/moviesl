package com.anjul.exercise.kittipay.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    lateinit var binding: B
    abstract fun getLayout(): Int
    var fragmentNavigator: FragmentNavigator? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        onBinding()
        return binding.root
    }

    private fun onBinding() {


    }

    private fun setTitle(title: String) {
//        (activity as HomeActivity).setActionBarTitle(title)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentNavigator = context as FragmentNavigator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun setTitle(id: Int) {
        setTitle(getString(id))
    }

    public interface FragmentNavigator {
        fun navigateFragmentWithId(fragmentId: Int, bundle: Bundle)
        fun navigateUp()

    }

}