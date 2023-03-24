package com.app.todoapp.presentation.noteSelected

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.NoteInfo
import com.example.domain.note.NotesRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteSelectedViewModel @Inject constructor(private val useCase: NotesRoomUseCase) :
    ViewModel() {

        fun delete(noteInfo: NoteInfo) {
            viewModelScope.launch {
                useCase.deleteNote(noteInfo)
            }
        }
}