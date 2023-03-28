package com.app.todoapp.presentation.noteSelected

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.todoapp.databinding.FragmentNoteSelectedBinding
import com.app.todoapp.util.Utils
import com.example.domain.entity.NoteInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteSelectedFragment : Fragment() {
    private var _binding: FragmentNoteSelectedBinding? = null
    private val binding get() = _binding!!
    private val args: NoteSelectedFragmentArgs by navArgs()
    private val viewModel : NoteSelectedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteSelectedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noteTitle.text = args.title
        binding.textNote.text = args.note

        binding.fabEdit.setOnClickListener {

        }

        binding.fabDelete.setOnClickListener {
            Utils.questionAlert(requireContext(),"Deleting", "Are you sure you want to delete this note?",
                { dialog, which ->
                    viewModel.delete(NoteInfo(args.noteId,args.note))
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