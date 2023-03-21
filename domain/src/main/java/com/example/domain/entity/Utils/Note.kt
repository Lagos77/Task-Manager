package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.hilt.EntryPoint

@Entity(tableName = "note_table")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val note: String
)