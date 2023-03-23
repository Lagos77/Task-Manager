package com.example.data.note.mapper

import com.example.data.note.entity.Note
import com.example.domain.entity.NoteInfo


//fun mapToNote(noteInfo: NoteInfo): Note {
//    return Note(noteInfo.id, noteInfo.note)
//}
//
//fun mapToNoteInfo(note: Note): NoteInfo {
//    return NoteInfo(note.id, note.note)
//}

fun NoteInfo.mapToNote(): Note {
    return Note(this.id, this.note)
}

fun Note.mapToNoteInfo() : NoteInfo  {
    return NoteInfo(this.id, this.note)
}