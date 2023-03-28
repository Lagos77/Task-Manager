package com.app.todoapp.presentation.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.todoapp.R
import com.example.domain.entity.NoteInfo

class ListAdapter() : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var adapterData = arrayListOf<NoteInfo>()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.cardTitle)
        val itemText: TextView = view.findViewById(R.id.cardDescription)
        val date: TextView = view.findViewById(R.id.dateAdded)
        val time: TextView = view.findViewById(R.id.timeAdded)
        val delete: ImageView = view.findViewById(R.id.delete)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: List<NoteInfo>) {
        adapterData.clear()
        adapterData.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = adapterData[position]
        holder.itemTitle.text = item.title
        holder.itemText.text = item.note
        holder.date.text = item.date
        holder.time.text = item.time
        holder.itemView.setOnClickListener {
            onClick?.invoke(position, adapterData[position])
        }
        holder.delete.setOnClickListener {
            deletePos?.invoke(position, adapterData[position])
        }
    }

    var onClick: ((Int, NoteInfo) -> Unit)? = null

    var deletePos: ((Int, NoteInfo) -> Unit)? = null

    fun setOnClickListener(onClick: (Int, NoteInfo) -> Unit) {
        this.onClick = onClick
    }

    fun deletePosition(deletePos: (Int, NoteInfo) -> Unit) {
        this.deletePos = deletePos
    }


}