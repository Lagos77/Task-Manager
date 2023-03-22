package com.example.domain.note

import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.domain.entity.NoteInfo
import com.example.domain.note.INotesRoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRoomUseCase @Inject constructor(private val INotesRoomRepository: INotesRoomRepository) {

    suspend fun getAllNotes(): Flow<List<NoteInfo>> {
        return INotesRoomRepository.getAllNotes()
    }

    suspend fun getNote(id: Int): NoteInfo {
        return INotesRoomRepository.getNote(id)
    }

    suspend fun addNote(noteInfo: NoteInfo) {
        return INotesRoomRepository.addNotes(noteInfo)
    }

    suspend fun deleteNote(noteInfo: NoteInfo) {
        return INotesRoomRepository.deleteNote(noteInfo)
    }

    suspend fun updateNote(noteInfo: NoteInfo) {
        return INotesRoomRepository.updateNote(noteInfo)
    }
}