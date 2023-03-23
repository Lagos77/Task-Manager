package com.app.todoapp.presentation.noteSelected

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.app.todoapp.R
import com.app.todoapp.databinding.FragmentNoteSelectedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteSelectedFragment : Fragment() {
    private var _binding: FragmentNoteSelectedBinding? = null
    private val binding get() = _binding!!
    private val args: NoteSelectedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteSelectedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textNote.text = args.note
    }

}