package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.AuthorDto;
import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacadeImpl implements AuthorFacade {

    private final AuthorService authorService;

    public AuthorFacadeImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void create(AuthorDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(AuthorDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        authorService.delete(id);
    }

    @Override
    public AuthorDto findById(String id) {
        return new AuthorDto(authorService.findById(id));
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorService.findAll().stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(AuthorDto dto, String id) {
        Author author = new Author();
        author.setEmail(dto.getEmail());
        author.setFirstName(dto.getFirstName());
        author.setSecondName(dto.getSecondName());
        if (id == null) {
            authorService.create(author);
        } else {
            author.setId(id);
            authorService.update(author);
        }
    }
}
