package ua.com.alevel.dao;

import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Note;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NoteDaoImpl implements NoteDao {

    private final String NOTES_PATH = "unit_7_patterns/notes.json";
    private List<Note> notes = new ArrayList<>();

    @Override
    public void create(Note note) {
        loadNotes();
        note.setId(generateId());
        notes.add(note);
        storeNotes();
    }

    @Override
    public void update(Note note) {
        loadNotes();
        if (existById(note.getId())) {
            Note current = findById(note.getId());
            current.setId(note.getId());
            current.setAuthorEmail(note.getAuthorEmail());
            current.setCreatedDate(note.getCreatedDate());
            current.setDescription(note.getDescription());
            current.setTitle(note.getTitle());
        }
        storeNotes();
    }

    @Override
    public void delete(String id) {
        loadNotes();
        notes.removeIf(note -> note.getId().equals(id));
        storeNotes();
    }

    @Override
    public Note findById(String id) {
        loadNotes();
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Note> findAll() {
        loadNotes();
        return notes;
    }

    @Override
    public List<Note> findByAuthorEmail(String email) {
        loadNotes();
        return notes.stream().filter(note -> note.getAuthorEmail().equals(email)).collect(Collectors.toList());
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        loadNotes();
        return notes.stream().anyMatch(note -> note.getId().equals(id));
    }

    public void loadNotes() {
        notes.clear();
        try {
            String notesOut = FileUtils.readFileToString(new File(NOTES_PATH), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            notes = objectMapper.readValue(notesOut, new TypeReference<List<Note>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeNotes() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String notesOut = gson.toJson(notes);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(NOTES_PATH))) {
            writer.append(notesOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
