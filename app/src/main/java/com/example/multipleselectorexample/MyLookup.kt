package com.example.multipleselectorexample

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class MyLookup(private val rv: RecyclerView): ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view = rv.findChildViewUnder(e.x, e.y)
        if (view != null) {
            return (rv.getChildViewHolder(view) as MyViewHolder)
                .getItemDetails()
        }
        return null
    }
}