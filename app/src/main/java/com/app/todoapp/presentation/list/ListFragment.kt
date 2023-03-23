package com.app.todoapp.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.todoapp.databinding.FragmentListBinding
import com.example.domain.adapter.Communicator
import com.example.domain.entity.NoteInfo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()
    private val listAdapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleList.adapter = listAdapter
        binding.fab.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToNoteFragment()
            findNavController().navigate(action)
        }
        observeList()
        viewModel.getAllNotes()
    }

    private fun observeList() {
        viewModel.allNotes.observe(viewLifecycleOwner) {
            listAdapter.addData(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    override fun passData(noteInfo: NoteInfo) {
//        val notes = noteInfo.note
//        val action = ListFragmentDirections.actionListFragmentToNoteFragment()
//    }
}
