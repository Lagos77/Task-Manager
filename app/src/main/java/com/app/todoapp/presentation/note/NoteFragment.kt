package com.app.todoapp.presentation.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.todoapp.databinding.FragmentNoteBinding
import com.app.todoapp.util.Utils
import com.app.todoapp.util.formatTime
import com.example.domain.entity.NoteInfo
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.LocalTime

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by viewModels()
    private val args: NoteFragmentArgs by navArgs()
    private var noteId = -1
    private val date = LocalDate.now()
    private val time = LocalTime.now().formatTime()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)

        if (noteId == args.noteId) {
            binding.fragmentTitle.text = "Create"
            binding.btnUpdate.text = "Create note"
        } else {
            binding.fragmentTitle.text = "Update"
            binding.inputTitle.setText(args.title)
            binding.edText.setText(args.note)
            binding.btnUpdate.text = "Update note"
        }

        binding.btnUpdate.setOnClickListener {
            when {
                noteId == args.noteId -> {
                    if (binding.edText.text.isNullOrBlank() || binding.inputTitle.text.isNullOrBlank()) {
                        Utils.showToast("Fields can't be empty", requireContext())
                    } else {
                        addNote()
                        val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
                        Utils.showToast("Note added!", requireContext())
                        findNavController().navigate(action)
                    }
                }

                noteId != args.noteId -> {
                    if (binding.edText.text.isNullOrBlank() || binding.inputTitle.text.isNullOrBlank()) {
                        Utils.showToast("Fields can't be empty", requireContext())
                    } else {
                        updateNote()
                        val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
                        Utils.showToast("Update successful!", requireContext())
                        findNavController().navigate(action)
                    }
                }
            }


        }

        return binding.root
    }

    private fun addNote() {
        val noteInfo =
            NoteInfo(
                0,
                binding.inputTitle.text.toString(),
                binding.edText.text.toString(),
                date.toString(),
                time.toString()
            )
        viewModel.addNote(noteInfo)
    }

    private fun updateNote() {
        val noteInfo = NoteInfo(
            args.noteId,
            binding.inputTitle.text.toString(),
            binding.edText.text.toString(), date.toString(), time.toString()
        )
        viewModel.updateNote(noteInfo)
    }

}