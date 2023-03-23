package com.app.todoapp.presentation.list

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.app.todoapp.R
import com.example.domain.adapter.Communicator
import com.example.domain.entity.NoteInfo

class ListAdapter() : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var adapterData = arrayListOf<NoteInfo>()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.cardTitle)
        val itemText: TextView = view.findViewById(R.id.cardDescription)

//        init {
//            onClickListener = OnClickListener { v ->
//            Log.d("TESTING", adapterPosition.toString())
//
//            }
//        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: List<NoteInfo>) {
        adapterData.clear()
        adapterData.addAll(data)
        notifyDataSetChanged()
    }

    fun deleteData(position: Int) {
        adapterData.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = adapterData[position]
        holder.itemText.text = item.note
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToNoteSelectedFragment(item.note)
            it.findNavController().navigate(action)
//            listener.passData(NoteInfo(item.id,item.note))
        }
//        with(holder.itemView) {
//            setOnClickListener(onClickListener)
//        }
    }


}