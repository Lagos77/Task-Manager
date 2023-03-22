package com.example.data.note

import com.example.data.note.entity.Note
import com.example.data.source.local.NoteDao
import com.example.domain.entity.NoteInfo
import com.example.domain.note.INotesRoomRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class NotesRoomRepositoryImpl @Inject constructor(private val dao: NoteDao) : INotesRoomRepository {

    override suspend fun addNotes(noteInfo: NoteInfo) {
        dao.addNote(Note(noteInfo.id, noteInfo.note))
    }

    override suspend fun getAllNotes(): Flow<List<NoteInfo>> {
        return dao.getAll().flatMapLatest { list->
            flow {
                list.map {
                    NoteInfo(it.id, it.note)
                }
            }
        }
    }

//    override suspend fun getNote(id: Int): NoteInfo {
//        TODO("Not yet implemented")
//    }

    override suspend fun deleteNote(noteInfo: NoteInfo) {
        dao.delete(Note(noteInfo.id, noteInfo.note))
    }

    override suspend fun updateNote(noteInfo: NoteInfo) {
        dao.updateNote(Note(noteInfo.id, noteInfo.note))
    }
}