package ua.com.alevel.facade;

import ua.com.alevel.dto.NoteDto;

import java.util.List;

public interface NoteFacade {

    void create(NoteDto dto);
    void update(NoteDto dto, String id);
    void delete(String id);
    NoteDto findById(String id);
    List<NoteDto> findAll();
    List<NoteDto> findByAuthorEmail(String email);
}
