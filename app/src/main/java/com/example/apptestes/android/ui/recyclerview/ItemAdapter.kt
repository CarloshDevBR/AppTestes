package com.example.apptestes.android.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptestes.databinding.RowItemBinding

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private var listTasks: List<String> = arrayListOf()
    private lateinit var listener: ItemListener

    private val startPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemTaskBinding = RowItemBinding.inflate(inflater, parent, false)

        return ItemViewHolder(itemTaskBinding, listener)
    }

    override fun getItemCount(): Int = listTasks.count()

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindDataRow(listTasks[position])
    }

    fun updateListTasks(list: List<String>) {
        listTasks = list
        notifyItemRangeChanged(startPosition, itemCount)
    }

    fun attachListener(taskListener: ItemListener) {
        listener = taskListener
    }
}