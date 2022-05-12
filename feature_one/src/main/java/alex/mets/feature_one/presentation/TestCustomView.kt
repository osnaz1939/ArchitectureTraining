package alex.mets.feature_one.presentation

import alex.mets.feature_one.R
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class TestCustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var labelPaint: Paint? = null
    private var labelText: String? = null

    init {
        setAttributes(context, attrs)
    }

    private fun setAttributes(context: Context?, attrs: AttributeSet?) {
        val a = context!!.obtainStyledAttributes(attrs, R.styleable.CustomView)
        labelText = a.getString(R.styleable.CustomView_text)
        labelPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        labelPaint!!.setTextSize(70f)
        labelPaint!!.setColor(Color.WHITE)
        labelPaint!!.setTextAlign(Paint.Align.LEFT)
        labelPaint!!.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        isSaveEnabled = true
    }

    fun setText(text: String) {
        labelText = text
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.d(
            "Custom",
            "inside onMeasure -$widthMeasureSpec : $heightMeasureSpec"
        )
        setMeasuredDimension(800, 300)
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        Log.d("Custom", "inside layout -")
        super.layout(l, t, r, b)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d(
            "Custom",
            "inside onLayout - $changed left : $left"
        )
        if (left == 0) {
            layout(50, 100, right, bottom)
        } else {
            super.onLayout(changed, left, top, right, bottom)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        Log.e("Custom ","onFinishInflate")
    }

    override fun onDraw(canvas: Canvas?) {
        Log.e("Custom ","onDraw")
        drawLabel(canvas!!)
    }

    private fun drawLabel(canvas: Canvas) {
        val x = paddingLeft.toFloat()
        //the y coordinate marks the bottom of the text, so we need to factor in the height
        val bounds = Rect()
        labelPaint!!.getTextBounds(labelText, 0, labelText!!.length, bounds)
        val y = (paddingTop + bounds.height()).toFloat()
        canvas.drawText(labelText!!, x, y, labelPaint!!)
    }

}