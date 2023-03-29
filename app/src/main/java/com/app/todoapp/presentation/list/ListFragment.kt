package com.app.todoapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.todoapp.databinding.FragmentListBinding
import com.app.todoapp.util.Utils
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

        listAdapter.setOnClickListener { _, item ->
            val action = ListFragmentDirections.actionListFragmentToNoteFragment(
                item.id,
                item.title,
                item.note,
                item.date,
                item.time
            )
            findNavController().navigate(action)
        }

        listAdapter.deletePosition { _, noteInfo ->
            Utils.questionAlert(
                requireContext(),
                "Deleting",
                "Are you sure you want to delete ${noteInfo.title}?",
                { _, _ ->
                    Utils.showToast("${noteInfo.title} deleted!", requireContext())
                    viewModel.delete(noteInfo)
                },
                { dialog, _ ->
                    dialog.dismiss()
                })
        }


        binding.recycleList.adapter = listAdapter
        binding.fab.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToNoteFragment(-1, "", "", "", "")
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
