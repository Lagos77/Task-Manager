package com.app.todoapp.presentation.note

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.todoapp.R
import com.app.todoapp.databinding.FragmentNoteBinding
import com.app.todoapp.util.Utils
import com.example.domain.entity.NoteInfo
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater,container,false)

        binding.fabAdd.setOnClickListener {
            addToDatabase()
            val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
            Utils.showToast("Successfully added!", requireContext())
            findNavController().navigate(action)
        }

        binding.fabCancel.setOnClickListener {
            val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    fun addToDatabase() {
        val noteInfo = NoteInfo(0,binding.edText.text.toString())
        viewModel.addNote(noteInfo)
    }
}