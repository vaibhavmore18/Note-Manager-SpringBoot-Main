package com.nabla.notemanager.notemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nabla.notemanager.notemanager.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    @Query(value = "SELECT * FROM note n WHERE category_name =:name", nativeQuery = true)
    List<Note> findNotesByCategoryName(@Param("name") String category_name);
}
