package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.NoteDao;
import ua.com.alevel.entity.Note;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteDao noteDao;
    private final AuthorDao authorDao;

    public NoteServiceImpl(NoteDao noteDao, AuthorDao authorDao) {
        this.noteDao = noteDao;
        this.authorDao = authorDao;
    }

    @Override
    public void create(Note note) {
        if (authorDao.existByEmail(note.getAuthorEmail())) {
            noteDao.create(note);
        }
    }

    @Override
    public void update(Note note) {
        noteDao.update(note);
    }

    @Override
    public void delete(String id) {
        noteDao.delete(id);
    }

    @Override
    public Note findById(String id) {
        return noteDao.findById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteDao.findAll();
    }

    @Override
    public List<Note> findByAuthorEmail(String email) {
        return noteDao.findByAuthorEmail(email);
    }
}
