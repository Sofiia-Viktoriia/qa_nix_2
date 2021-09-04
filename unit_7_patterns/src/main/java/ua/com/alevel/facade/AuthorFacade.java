package ua.com.alevel.facade;

import ua.com.alevel.dto.AuthorDto;

import java.util.List;

public interface AuthorFacade {

    void create(AuthorDto dto);
    void update(AuthorDto dto, String id);
    void delete(String id);
    AuthorDto findById(String id);
    List<AuthorDto> findAll();
}
