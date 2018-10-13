package com.firstproject.project.controller

import com.firstproject.project.model.Note
import com.firstproject.project.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class ControllerNote {

    @Autowired
    lateinit var noteRepository: NoteRepository

    @GetMapping
    fun list(): List<Note> {
        return noteRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody note: Note): Note {
        return noteRepository.save(note)
    }

    @PutMapping("{id}")
    fun change(@PathVariable id: Long, @RequestBody note: Note): Note {
        if (noteRepository.existsById(id)) {
            val safeNote = note.copy(id)
            return noteRepository.save(safeNote)
        }
        return Note()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if(noteRepository.existsById(id)) {
            noteRepository.deleteById(id)
        }
    }
}