package com.example.battletanks.drawers

import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import com.example.battletanks.CELL_SIZE
import com.example.battletanks.binding

class GridDrawer(private val context: FrameLayout) {
    private val allines = mutableListOf<View>()

    fun removeGrid() {
        val container = binding.container
        allines.forEach {
            container.removeView(it)
        }
    }

    fun drawGrid() {
        val container = binding.container
        drawHorizonalLines(container)
        drawVerticalLines(container)
    }

    private fun drawHorizonalLines(container: FrameLayout?) {
        var topMargin = 0
        while (topMargin <= container!!.height) {
            val horizontalLine = View(container.context)
            val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1)
            topMargin += CELL_SIZE
            layoutParams.topMargin = topMargin
            horizontalLine.layoutParams = layoutParams
            horizontalLine.setBackgroundColor(Color.WHITE)
            allines.add(horizontalLine)
            container.addView(horizontalLine)
        }
    }

    private fun drawVerticalLines(container: FrameLayout?) {
        var leftMargin = 0
        while (leftMargin <= container!!.width) {
            val verticalLine = View(container.context)
            val layoutParams = FrameLayout.LayoutParams(1, FrameLayout.LayoutParams.MATCH_PARENT)
            leftMargin += CELL_SIZE
            layoutParams.leftMargin = leftMargin
            verticalLine.layoutParams = layoutParams
            verticalLine.setBackgroundColor(Color.WHITE)
            allines.add(verticalLine)
            container.addView(verticalLine)
        }
    }
}