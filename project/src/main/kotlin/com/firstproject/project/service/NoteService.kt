package com.firstproject.project.service

import com.firstproject.project.model.Note
import com.firstproject.project.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {

    fun all(): List<Note> {
        return noteRepository.findAll().toList()
    }

    fun deleteById(id: Long) {
        noteRepository.deleteById(id)
    }

    fun existsById(id: Long): Boolean {
        return noteRepository.existsById(id)
    }

    fun save(note: Note): Note {
        return noteRepository.save(note)
    }

    fun change(id: Long, note: Note): Note {
        var safeNote = note.copy(id = id)
        return save(safeNote)
    }

}