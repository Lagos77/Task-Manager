package com.app.todoapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.NoteInfo
import com.example.domain.note.NotesRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val roomUseCase: NotesRoomUseCase) : ViewModel() {

    private val _allNotes = MutableLiveData<List<NoteInfo>>()
    val allNotes: LiveData<List<NoteInfo>> get() = _allNotes

    fun getAllNotes() {
        viewModelScope.launch {
            roomUseCase.getAllNotes().collect {
                _allNotes.postValue(it)
            }
        }
    }

    fun delete(noteInfo: NoteInfo) {
        viewModelScope.launch {
            roomUseCase.deleteNote(noteInfo)
        }
    }
}