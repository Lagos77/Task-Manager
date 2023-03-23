package com.app.todoapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.todoapp.databinding.FragmentListBinding
import com.example.domain.entity.NoteInfo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()
    private val notesAdapter: NotesAdapter by lazy { NotesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleList.adapter = notesAdapter
        binding.fab.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToNoteFragment()
            findNavController().navigate(action)
        }
        observeList()
        viewModel.getAllNotes()
    }

    private fun observeList() {
        viewModel.allNotes.observe(viewLifecycleOwner) {
            notesAdapter.addData(it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
