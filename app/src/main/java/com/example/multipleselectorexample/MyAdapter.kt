package com.example.multipleselectorexample

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listItems: List<MainActivity.Person>, private val context: Context):
    RecyclerView.Adapter<MyViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private var tracker: SelectionTracker<Long>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = listItems[position].name
        holder.phone.text = listItems[position].phone
        val parent = holder.name.parent as LinearLayout
        if (tracker!!.isSelected(position.toLong())) {
            parent.background = ColorDrawable(
                Color.parseColor("#80deea")
            )
        } else {
            parent.background = ColorDrawable(Color.WHITE)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setTracker(tracker: SelectionTracker<Long>?) {
        this.tracker = tracker
    }
}