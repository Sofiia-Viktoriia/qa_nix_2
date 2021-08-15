package ua.com.alevel.services;

import ua.com.alevel.dao.NoteDao;
import ua.com.alevel.entity.Note;

public class NoteService {

    private NoteDao noteDao = new NoteDao();

    public void create(Note note) {
        noteDao.create(note);
    }

    public void update(Note note) {
        noteDao.update(note);
    }

    public void delete(String id) {
        noteDao.delete(id);
    }

    public Note findById(String id) {
        return noteDao.findById(id);
    }

    public Note[] findAll() {
        return noteDao.findAll();
    }
}
