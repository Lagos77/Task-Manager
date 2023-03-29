package com.example.domain.note

import com.example.domain.entity.NoteInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRoomUseCase @Inject constructor(private val notesRepository: INotesRoomRepository) {

    suspend fun getAllNotes(): Flow<List<NoteInfo>> {
        return notesRepository.getAllNotes()
    }

    suspend fun getNote(id: Int): NoteInfo {
        return notesRepository.getNote(id)
    }

    suspend fun addNote(noteInfo: NoteInfo) {
        return notesRepository.addNotes(noteInfo)
    }

    suspend fun deleteNote(noteInfo: NoteInfo) {
        return notesRepository.deleteNote(noteInfo)
    }

    suspend fun updateNote(noteInfo: NoteInfo) {
        return notesRepository.updateNote(noteInfo)
    }
}