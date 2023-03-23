package com.app.todoapp.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.todoapp.databinding.ItemBinding
import com.example.domain.entity.NoteInfo
import javax.inject.Inject

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private lateinit var binding: ItemBinding
    private var adapterData = arrayListOf<NoteInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =   LayoutInflater.from(parent.context)
        binding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(adapterData[position])
    }

    fun addData(data: List<NoteInfo>) {
        adapterData.clear()
        adapterData.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteInfo){
            binding.apply {
                cardDescription.text = item.note
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<NoteInfo>(){
        override fun areItemsTheSame(oldItem: NoteInfo, newItem: NoteInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteInfo, newItem: NoteInfo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

}