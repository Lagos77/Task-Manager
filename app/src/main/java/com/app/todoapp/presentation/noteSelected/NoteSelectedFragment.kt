package com.app.todoapp.presentation.noteSelected

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.todoapp.R
import com.app.todoapp.databinding.FragmentNoteSelectedBinding
import com.app.todoapp.util.Utils
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

        binding.fabDelete.setOnClickListener {
            Utils.questionAlert(requireContext(),"Deleting", "Are you sure you want to delete this note?",
                { dialog, which ->
                    navigationList()
                },
                { dialog, which ->
                    dialog.dismiss()
                })
        }

        binding.fabCancel.setOnClickListener {
            navigationList()
        }
    }

    private fun navigationList() {
        val action = NoteSelectedFragmentDirections.actionNoteSelectedFragmentToListFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}