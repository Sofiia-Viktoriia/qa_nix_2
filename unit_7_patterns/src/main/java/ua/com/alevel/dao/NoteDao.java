package ua.com.alevel.dao;

import ua.com.alevel.entity.Note;

import java.util.List;

public interface NoteDao {

    void create(Note note);
    void update(Note note);
    void delete(String id);
    Note findById(String id);
    List<Note> findAll();
    List<Note> findByAuthorEmail(String email);
}
