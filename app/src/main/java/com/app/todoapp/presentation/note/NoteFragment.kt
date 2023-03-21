package com.app.todoapp.presentation.note

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.todoapp.R
import com.app.todoapp.databinding.FragmentNoteBinding
import com.app.todoapp.util.Utils
import com.google.android.material.snackbar.Snackbar

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    @SuppressLint("ShowToast")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater,container,false)

        binding.fabAdd.setOnClickListener {
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
}