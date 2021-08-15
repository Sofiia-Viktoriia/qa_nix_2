package ua.com.alevel.dao;

import ua.com.alevel.db.NoteDB;
import ua.com.alevel.entity.Note;

public class NoteDao {

    private NoteDB noteDB = new NoteDB();

    public void create(Note note) {
        noteDB.create(note);
    }

    public void update(Note note) {
        noteDB.update(note);
    }

    public void delete(String id) {
        noteDB.delete(id);
    }

    public Note findById(String id) {
        return noteDB.findById(id);
    }

    public Note[] findAll() {
        return noteDB.findAll();
    }
}
