package com.app.todoapp.presentation.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.app.todoapp.databinding.FragmentNoteBinding
import com.app.todoapp.util.Constants.Create
import com.app.todoapp.util.Constants.CreateNote
import com.app.todoapp.util.Constants.Update
import com.app.todoapp.util.Constants.UpdateNote
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by viewModels()
    private val args: NoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)

        viewModel.createNotification(requireContext())

        if (-1 == args.noteId) {
            binding.fragmentTitle.text = Create
            binding.btnUpdate.text = CreateNote
        } else {
            binding.fragmentTitle.text = Update
            binding.inputTitle.setText(args.title)
            binding.edText.setText(args.note)
            binding.btnUpdate.text = UpdateNote
        }


        binding.btnUpdate.setOnClickListener {
            viewModel.checkNote(
                args.noteId,
                -1,
                binding.inputTitle,
                binding.edText,
                this,
                requireContext()
            )
        }

        binding.timer.setOnClickListener {
            viewModel.showDateTimePicker(binding.inputTitle.text.toString(), requireContext(), this)
        }

        return binding.root
    }


}