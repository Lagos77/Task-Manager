package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.note.NotesRoomRepositoryImpl
import com.example.data.note.entity.Note
import com.example.data.source.local.NoteDao
import com.example.data.source.local.NotesDatabase
import com.example.domain.note.INotesRoomRepository
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
    fun provideNotesDao(database: NotesDatabase) : NoteDao {
        return database.getNoteDao()
    }

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) : NotesDatabase {
        return Room.databaseBuilder(
            context, NotesDatabase::class.java, "NOTE_DATABASE")
            .build()
    }

    @Provides
    fun providesINotesRoomRepository(iNotesRoomRepositoryImpl: NotesRoomRepositoryImpl): INotesRoomRepository =
        iNotesRoomRepositoryImpl
}