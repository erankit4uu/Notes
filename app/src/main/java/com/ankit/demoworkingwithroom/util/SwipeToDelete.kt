package com.ankit.demoworkingwithroom.util

import android.support.v7.widget.RecyclerView

import android.support.v7.widget.helper.ItemTouchHelper
import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import com.ankit.demoworkingwithroom.R


abstract class SwipeToDelete internal constructor(internal var mContext: Context) : ItemTouchHelper.Callback() {
    private val mClearPaint: Paint
    private val mBackground: ColorDrawable = ColorDrawable()
    private val backgroundColor: Int
    private val deleteDrawable: Drawable?
    private val intrinsicWidth: Int
    private val intrinsicHeight: Int


    init {
        backgroundColor = Color.parseColor("#b80f0a")
        mClearPaint = Paint()
        mClearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        deleteDrawable = ContextCompat.getDrawable(mContext, R.drawable.ic_delete_forever_red_500_24dp)
        intrinsicWidth = deleteDrawable!!.intrinsicWidth
        intrinsicHeight = deleteDrawable.intrinsicHeight


    }


    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        return ItemTouchHelper.Callback.makeMovementFlags(0, ItemTouchHelper.LEFT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        viewHolder1: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val itemView = viewHolder.itemView
        val itemHeight = itemView.height

        val isCancelled = dX == 0f && !isCurrentlyActive

        if (isCancelled) {
            clearCanvas(
                c,
                itemView.right + dX,
                itemView.top.toFloat(),
                itemView.right.toFloat(),
                itemView.bottom.toFloat()
            )
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        mBackground.color = backgroundColor
        mBackground.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
        mBackground.draw(c)

        val deleteIconTop = itemView.top + (itemHeight - intrinsicHeight) / 2
        val deleteIconMargin = (itemHeight - intrinsicHeight) / 2
        val deleteIconLeft = itemView.right - deleteIconMargin - intrinsicWidth
        val deleteIconRight = itemView.right - deleteIconMargin
        val deleteIconBottom = deleteIconTop + intrinsicHeight


        deleteDrawable!!.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom)
        deleteDrawable.draw(c)

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)


    }

    private fun clearCanvas(c: Canvas, left: Float?, top: Float?, right: Float?, bottom: Float?) {
            c.drawRect(left!!, top!!, right!!, bottom!!, mClearPaint)
        }

    }

fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
    return 0.7f
}

