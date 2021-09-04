package ua.com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Author;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorDaoImpl implements AuthorDao {

    private final String AUTHORS_PATH = "unit_7_patterns/authors.json";
    private List<Author> authors = new ArrayList<>();

    @Override
    public void create(Author author) {
        loadAuthors();
        author.setId(generateId());
        authors.add(author);
        storeAuthors();
    }

    @Override
    public void update(Author author) {
        loadAuthors();
        if (existById(author.getId())) {
            Author current = findById(author.getId());
            current.setId(author.getId());
            current.setFirstName(author.getFirstName());
            current.setSecondName(author.getSecondName());
            current.setEmail(author.getEmail());
        }
        storeAuthors();
    }

    @Override
    public void delete(String id) {
        loadAuthors();
        authors.removeIf(author -> author.getId().equals(id));
        storeAuthors();
    }

    @Override
    public Author findById(String id) {
        loadAuthors();
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Author> findAll() {
        loadAuthors();
        return authors;
    }

    @Override
    public boolean existByEmail(String email) {
        loadAuthors();
        return authors.stream().anyMatch(author -> author.getEmail().equals(email));
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        loadAuthors();
        return authors.stream().anyMatch(author -> author.getId().equals(id));
    }

    public void loadAuthors() {
        authors.clear();
        try {
            String authorsOut = FileUtils.readFileToString(new File(AUTHORS_PATH), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            authors = objectMapper.readValue(authorsOut, new TypeReference<List<Author>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeAuthors() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String authorsOut = gson.toJson(authors);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(AUTHORS_PATH))) {
            writer.append(authorsOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
