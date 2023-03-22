package com.example.domain.note


import com.example.domain.entity.NoteInfo
import kotlinx.coroutines.flow.Flow


interface INotesRoomRepository {

    suspend fun addNotes(noteInfo: NoteInfo)

    suspend fun getAllNotes() : Flow<List<NoteInfo>>

//    suspend fun getNote(id: Int) : NoteInfo

    suspend fun deleteNote(noteInfo: NoteInfo)

    suspend fun updateNote(noteInfo: NoteInfo)
}