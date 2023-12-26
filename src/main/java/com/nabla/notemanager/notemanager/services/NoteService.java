package com.nabla.notemanager.notemanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nabla.notemanager.notemanager.entities.Note; 

@Service
public interface NoteService {
    public Note getNoteById(int note_id);
    List<Note> getNotes();
    Note addNote(Note note, int user_id);
    public Note updateNote(Note note, int noteId);
    public void deleteNote(int note_id);
    public List<Note> getNotesByCategoryName(String category_name);
}
