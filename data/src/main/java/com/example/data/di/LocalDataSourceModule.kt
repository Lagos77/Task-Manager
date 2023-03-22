package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.note.entity.Note
import com.example.data.source.local.NoteDao
import com.example.data.source.local.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideNotesDao(database: NotesDatabase) : NoteDao {
        return database.getNoteDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) : NotesDatabase {
        return Room.databaseBuilder(
            context, NotesDatabase::class.java, "NOTE_DATABASE")
            .build()
    }

    @Provides
    fun provideEntity() = Note()
}