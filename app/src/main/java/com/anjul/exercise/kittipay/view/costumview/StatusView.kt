package com.anjul.exercise.kittipay.view.costumview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.anjul.exercise.kittipay.R
import com.anjul.exercise.kittipay.enums.Status

class StatusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val progressBar: ProgressBar
    private val noInternetTextView: TextView
    private val noContentTextView: TextView
    private val errorTextView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_status, this, true)
        progressBar = findViewById(R.id.progressBar)
        noInternetTextView = findViewById(R.id.noInternetTextView)
        noContentTextView = findViewById(R.id.noContentTextView)
        errorTextView = findViewById(R.id.errorTextView)

        context.withStyledAttributes(attrs, R.styleable.StatusView) {
            val initialStatus = getInt(R.styleable.StatusView_initialStatus, 0)
            showStatus(Status.values()[initialStatus])
        }
    }

    fun showStatus(status: Status) {
        when (status) {
            Status.LOADING -> {
                progressBar.visibility = View.VISIBLE
                noInternetTextView.visibility = View.GONE
                noContentTextView.visibility = View.GONE
                errorTextView.visibility = View.GONE
            }
            Status.NO_INTERNET -> {
                progressBar.visibility = View.GONE
                noInternetTextView.visibility = View.VISIBLE
                noContentTextView.visibility = View.GONE
                errorTextView.visibility = View.GONE
            }
            Status.EMPTY -> {
                progressBar.visibility = View.GONE
                noInternetTextView.visibility = View.GONE
                noContentTextView.visibility = View.VISIBLE
                errorTextView.visibility = View.GONE
            }
            Status.ERROR -> {
                progressBar.visibility = View.GONE
                noInternetTextView.visibility = View.GONE
                noContentTextView.visibility = View.GONE
                errorTextView.visibility = View.VISIBLE
            }
            Status.OK ->{
                progressBar.visibility = View.GONE
                noInternetTextView.visibility = View.GONE
                noContentTextView.visibility = View.GONE
                errorTextView.visibility = View.GONE
            }
        }
    }
}
