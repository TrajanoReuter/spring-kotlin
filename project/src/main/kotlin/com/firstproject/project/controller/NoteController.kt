package com.firstproject.project.controller

import com.firstproject.project.model.Note
import com.firstproject.project.service.NoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController (private  val noteService: NoteService) {

    @GetMapping
    fun list(): ResponseEntity<List<Note>> {
        val allNotes = noteService.all().toList()
        return ResponseEntity.ok(allNotes)
    }

    @PostMapping
    fun add(@RequestBody note: Note): ResponseEntity<Note> {
        val savedNote = noteService.save(note)
        return ResponseEntity.ok(savedNote)
    }

    @PutMapping("{id}")
    fun change(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> {
        if (noteService.existsById(id)) {
            val alteredNote = noteService.change(id, note)
            return ResponseEntity.ok(alteredNote)
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        if(noteService.existsById(id)) {
            noteService.deleteById(id)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}