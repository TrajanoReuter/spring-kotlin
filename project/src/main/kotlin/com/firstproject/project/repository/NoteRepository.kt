package com.firstproject.project.repository

import com.firstproject.project.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository <Note, Long>