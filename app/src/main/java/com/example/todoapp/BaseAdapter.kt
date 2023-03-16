package com.example.todoapp

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings

abstract class BaseAdapter<IB : ViewBinding, T>(private val layoutId: Int) :
    RecyclerView.Adapter<BaseAdapter<IB, T>.BaseHolder>() {

    private var onClick: ((T, Int, View) -> Unit)? = null
    private var onLongClick: ((T, Int, View) -> Unit)? = null
    protected var list = ArrayList<T>()

    abstract fun bindView(binding: IB, position: Int)

    abstract fun getClickableView(binding: IB): ArrayList<View>

    abstract fun getLongClickableView(binding: IB): ArrayList<View>

    inner class BaseHolder(val binding: IB) : RecyclerView.ViewHolder(binding.root) {
        init {
            for (view in getClickableView(binding))
                view.setOnClickListener {
                    onClick?.let { it1 -> it1(list[adapterPosition], adapterPosition, it) }
                }
            for (view in getLongClickableView(binding)) {

                view.setOnLongClickListener { v ->
                    onLongClick?.let { it1 -> it1(list[adapterPosition], adapterPosition, v) }
                    true
                }
            }

        }
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
//        val binding: IB = ViewBinding()
//    }
}