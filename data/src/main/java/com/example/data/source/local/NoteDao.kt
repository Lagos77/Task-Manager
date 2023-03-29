package com.example.data.source.local


import androidx.room.*
import com.example.data.note.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT * FROM note_table WHERE id like :id")
    fun getNote(id: Int) : Note
}