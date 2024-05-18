package com.anjul.exercise.kittipay.core

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.appbar.MaterialToolbar



abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
    }

    fun showProgress() {


    }

    fun initToolbar(toolbar: MaterialToolbar) {
        setSupportActionBar(toolbar)
        if (hasBackArrow())
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
// todo       supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.ic_toolbar_arrow))
        supportActionBar?.setHomeButtonEnabled(true)
    }

    abstract fun getLayout(): Int

    open fun hasBackArrow(): Boolean {
        return true
    }

    override
    fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    abstract fun onCreateViewModel(savedInstanceState: Bundle?)

}