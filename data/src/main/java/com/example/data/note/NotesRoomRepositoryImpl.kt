package com.example.data.note

import android.annotation.SuppressLint
import com.example.data.note.entity.Note
import com.example.data.note.mapper.mapToNote
import com.example.data.note.mapper.mapToNoteInfo
import com.example.data.source.local.NoteDao
import com.example.domain.entity.NoteInfo
import com.example.domain.note.INotesRoomRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class NotesRoomRepositoryImpl @Inject constructor(private val dao: NoteDao) : INotesRoomRepository {

    override suspend fun addNotes(noteInfo: NoteInfo) {
        dao.addNote(noteInfo.mapToNote())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getAllNotes(): Flow<List<NoteInfo>> {
        return dao.getAll().mapLatest { list ->
            list.map { it.mapToNoteInfo() }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getNote(id: Int): NoteInfo {
        return dao.getNote(id).mapToNoteInfo()
    }

    override suspend fun deleteNote(noteInfo: NoteInfo) {
        dao.delete(noteInfo.mapToNote())
    }

    override suspend fun updateNote(noteInfo: NoteInfo) {
        dao.updateNote(noteInfo.mapToNote())
    }
}