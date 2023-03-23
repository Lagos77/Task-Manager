package com.example.domain.adapter

import com.example.domain.entity.NoteInfo
import java.text.FieldPosition

interface Communicator {
    fun passData(noteInfo: NoteInfo)
}