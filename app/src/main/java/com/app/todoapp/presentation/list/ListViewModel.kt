package com.app.todoapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.NoteInfo
import com.example.domain.note.NotesRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val roomUseCase: NotesRoomUseCase) : ViewModel() {

    fun getAllNotes() {
        viewModelScope.launch {
            roomUseCase.getAllNotes()
        }
    }

    fun getNote(id: Int) {
        viewModelScope.launch {
            roomUseCase.getNote(id)
        }
    }
}