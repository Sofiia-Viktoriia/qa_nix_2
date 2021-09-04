package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.AuthorDto;
import ua.com.alevel.dto.ResponseContainer;
import ua.com.alevel.facade.AuthorFacade;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorFacade authorFacade;

    public AuthorController(AuthorFacade authorFacade) {
        this.authorFacade = authorFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<String>> create(@RequestBody AuthorDto dto) {
        authorFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>("Author successfully created."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<String>> update(@RequestBody AuthorDto dto, @PathVariable String id) {
        authorFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>("Author successfully updated."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<String>> delete(@PathVariable String id) {
        authorFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>("Author successfully deleted."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<AuthorDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(authorFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<AuthorDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(authorFacade.findAll()));
    }
}
