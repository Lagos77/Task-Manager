package com.app.todoapp.presentation.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.NoteInfo
import com.example.domain.note.NotesRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val roomUseCase: NotesRoomUseCase) : ViewModel(){

    fun addNote(noteInfo: NoteInfo) {
        viewModelScope.launch {
            roomUseCase.addNote(noteInfo)
        }
    }

    fun updateNote(noteInfo: NoteInfo) {
        viewModelScope.launch {
            roomUseCase.updateNote(noteInfo)
        }
    }
}