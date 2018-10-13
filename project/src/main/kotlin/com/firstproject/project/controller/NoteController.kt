package com.firstproject.project.controller

import com.firstproject.project.model.Note
import com.firstproject.project.service.NoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController (private  val noteService: NoteService) {

    @GetMapping
    fun list(): List<Note> {
        return noteService.all().toList()
    }

    @PostMapping
    fun add(@RequestBody note: Note): Note {
        return noteService.save(note)
    }

    @PutMapping("{id}")
    fun change(@PathVariable id: Long, @RequestBody note: Note): Note {
        if (noteService.existsById(id)) {
            return noteService.change(id, note)
        }
        return Note()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if(noteService.existsById(id)) {
            noteService.deleteById(id)
        }
    }
}