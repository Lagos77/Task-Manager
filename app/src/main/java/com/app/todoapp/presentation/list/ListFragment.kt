package com.app.todoapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.todoapp.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()
    private val listAdapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter.setOnClickListener { index, item ->
            val action = ListFragmentDirections.actionListFragmentToNoteSelectedFragment(
                item.id,
                item.title,
                item.note,
            )
            findNavController().navigate(action)
        }
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

}
