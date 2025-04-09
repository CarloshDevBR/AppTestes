package com.example.apptestes.android.ui.recyclerview

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.apptestes.databinding.RowItemBinding

class ItemViewHolder(
    private val itemBinding: RowItemBinding,
    private val listener: ItemListener
) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bindDataRow(task: String) {
        itemBinding.textDescription.text = task

        setEvents(task)
    }

    private fun setEvents(task: String) {
        itemBinding.textDescription.setOnClickListener {
            AlertDialog
                .Builder(itemView.context)
                .setTitle("Remover")
                .setMessage("Deseja mesmo remover?")
                .setPositiveButton("confirmar") { dialog, which -> listener.onRemove(task) }
                .setNeutralButton("cancelar", null)
                .show()
        }
    }
}