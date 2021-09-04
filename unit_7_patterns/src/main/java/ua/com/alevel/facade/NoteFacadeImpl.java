package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.NoteDto;
import ua.com.alevel.entity.Note;
import ua.com.alevel.service.NoteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteFacadeImpl implements NoteFacade {

    private final NoteService noteService;

    public NoteFacadeImpl(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public void create(NoteDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(NoteDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        noteService.delete(id);
    }

    @Override
    public NoteDto findById(String id) {
        return new NoteDto(noteService.findById(id));
    }

    @Override
    public List<NoteDto> findAll() {
        return noteService.findAll().stream().map(NoteDto::new).collect(Collectors.toList());
    }

    @Override
    public List<NoteDto> findByAuthorEmail(String email) {
        return noteService.findByAuthorEmail(email).stream().map(NoteDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(NoteDto dto, String id) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setDescription(dto.getDescription());
        note.setCreatedDate(dto.getCreatedDate());
        note.setAuthorEmail(dto.getAuthorEmail());
        if (id == null) {
            noteService.create(note);
        } else {
            note.setId(id);
            noteService.update(note);
        }
    }
}
