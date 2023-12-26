package com.nabla.notemanager.notemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabla.notemanager.notemanager.entities.Note;
import com.nabla.notemanager.notemanager.entities.User;
import com.nabla.notemanager.notemanager.repository.NoteRepository;
import com.nabla.notemanager.notemanager.repository.UserRepository;


@Service
public class NoteServiceImplementation implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Note addNote(Note note, int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            note.setUser(user);
            note.setCreatedBy(userId);
            note.setUpdatedBy(userId);
            return noteRepository.save(note);
        } else {
            // Handle user not found
            return null;
        }
    }

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(int note_id) {
        Optional<Note> optionalNote = noteRepository.findById(note_id);
        return optionalNote.orElse(null);
    }

    @Override
    public Note updateNote(Note note, int noteId) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();
            existingNote.setNote_title(note.getNote_title());
            existingNote.setNote_description(note.getNote_description());
            existingNote.setCategory_name(note.getCategory_name());
            existingNote.setUpdatedBy(noteId);
            return noteRepository.save(existingNote);
        } else {
            // Handle note not found
            return null;
        }
    }

    // delete
    @Override
    public void deleteNote(int note_id) {
        noteRepository.deleteById(note_id);
    }

    @Override
    public List<Note> getNotesByCategoryName(String category_name) {
        return noteRepository.findNotesByCategoryName(category_name);
    }
}
