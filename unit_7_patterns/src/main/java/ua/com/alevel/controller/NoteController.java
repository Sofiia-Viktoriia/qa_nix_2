package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.NoteDto;
import ua.com.alevel.dto.ResponseContainer;
import ua.com.alevel.facade.NoteFacade;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteFacade noteFacade;

    public NoteController(NoteFacade noteFacade) {
        this.noteFacade = noteFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<String>> create(@RequestBody NoteDto dto) {
        noteFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>("Note successfully created."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<String>> update(@RequestBody NoteDto dto, @PathVariable String id) {
        noteFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>("Note successfully updated."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<String>> delete(@PathVariable String id) {
        noteFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>("Note successfully deleted."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<NoteDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(noteFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<NoteDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(noteFacade.findAll()));
    }

    @GetMapping("findByEmail/{email}")
    public ResponseEntity<ResponseContainer<List<NoteDto>>> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(new ResponseContainer<>(noteFacade.findByAuthorEmail(email)));
    }
}
