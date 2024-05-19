package com.anjul.exercise.kittipay.view.costumview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.withStyledAttributes
import com.anjul.exercise.kittipay.R

class BulletTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var bulletRadius = 10f
    private var bulletSpacing = 20f
    private val bulletPaint = Paint().apply { isAntiAlias = true }

    init {
        context.withStyledAttributes(attrs, R.styleable.BulletTextView) {
            bulletPaint.color = getColor(
                R.styleable.BulletTextView_bulletColor,
                context.getColor(android.R.color.black)
            )
            bulletRadius = getDimension(R.styleable.BulletTextView_bulletRadius, bulletRadius)
            bulletSpacing = getDimension(R.styleable.BulletTextView_bulletSpacing, bulletSpacing)
        }
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText("$text  ", type)
    }

    override fun onDraw(canvas: Canvas) {
        val bulletCenterX = paddingLeft + bulletRadius
        val bulletCenterY = (height / 2).toFloat()

        canvas.drawCircle(bulletCenterX, bulletCenterY, bulletRadius, bulletPaint)

        canvas.save()
        canvas.translate(bulletRadius * 2 + bulletSpacing, 0f)

        super.onDraw(canvas)
        canvas.restore()
    }
}
