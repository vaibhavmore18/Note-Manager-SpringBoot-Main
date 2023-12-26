package com.nabla.notemanager.notemanager.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nabla.notemanager.notemanager.entities.Note;
import com.nabla.notemanager.notemanager.services.NoteService;
import com.nabla.notemanager.notemanager.services.UserService;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;
    
    @Autowired
    public UserService userService;

    // Read All User
    @GetMapping("/notes")
    public List<Note> getNotes() {
        return this.noteService.getNotes();
    }

    @GetMapping("/notes/{note_id}")
    public Note getNoteById(@PathVariable("note_id") String note_id) {
        return this.noteService.getNoteById(Integer.parseInt(note_id));
    }

    @PostMapping("/addNote/{userId}")
        public ResponseEntity<Note> addNote(@RequestBody Note note, @PathVariable("userId") int userId) {
        Note addedNote = noteService.addNote(note, userId);
            return (addedNote != null)
                ? new ResponseEntity<>(addedNote, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateNote/{note_id}")
    public ResponseEntity<Note> updateNote(@PathVariable("note_id") int note_id, @RequestBody Note note) {
        Note updatedNote = noteService.updateNote(note, note_id);
        return (updatedNote != null)
                ? new ResponseEntity<>(updatedNote, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete Note
    @DeleteMapping("/deleteNote/{note_id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable String note_id) {
        try {
            noteService.deleteNote(Integer.parseInt(note_id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/note/{category_name}")
    public ResponseEntity<List<Note>> getNotesByCategoryName(@PathVariable String category_name) {
        System.out.println(category_name);
        List<Note> notes = noteService.getNotesByCategoryName(category_name);
        if (notes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        }
    }

}
