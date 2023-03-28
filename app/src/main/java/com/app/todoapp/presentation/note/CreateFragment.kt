package com.app.todoapp.presentation.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.todoapp.databinding.FragmentCreateBinding
import com.app.todoapp.util.Utils
import com.example.domain.entity.NoteInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : Fragment() {
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.btnUpdate.setOnClickListener {
            if (binding.edText.text.isNullOrBlank() || binding.inputTitle.text.isNullOrBlank()) {
                Utils.showToast("Fields can't be empty", requireContext())
            } else {
                addToDatabase()
                val action = CreateFragmentDirections.actionCreateFragmentToListFragment()
                Utils.showToast("Successfully added!", requireContext())
                findNavController().navigate(action)
            }

        }

//        binding.fabCancel.setOnClickListener {
//            val action = CreateFragmentDirections.actionNoteFragmentToListFragment()
//            findNavController().navigate(action)
//        }

        return binding.root
    }

    private fun addToDatabase() {
        val noteInfo =
            NoteInfo(0, binding.inputTitle.text.toString(), binding.edText.text.toString())
        viewModel.addNote(noteInfo)
    }
}