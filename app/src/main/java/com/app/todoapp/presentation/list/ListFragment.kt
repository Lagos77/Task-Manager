package com.app.todoapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.todoapp.databinding.FragmentListBinding
import javax.inject.Inject

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var listAdapter: ListAdapter

    @Inject
    lateinit var notesAdapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
//        var addedList = arrayListOf("Kotlin", "MVVM", "Retrofit", "Annotations & Coroutines")
//        listAdapter = ListAdapter(addedList)
//        binding.recycleList.adapter = listAdapter

        binding.fab.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToNoteFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
