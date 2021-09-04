package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.NoteDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Note;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;
    private final NoteDao noteDao;

    public AuthorServiceImpl(AuthorDao authorDao, NoteDao noteDao) {
        this.authorDao = authorDao;
        this.noteDao = noteDao;
    }

    @Override
    public void create(Author author) {
        if (!authorDao.existByEmail(author.getEmail())) {
            authorDao.create(author);
        }
    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Override
    public void delete(String id) {
        Author author = authorDao.findById(id);
        List<Note> notes = noteDao.findByAuthorEmail(author.getEmail());
        authorDao.delete(id);
        for (Note note : notes) {
            noteDao.delete(note.getId());
        }
    }

    @Override
    public Author findById(String id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
