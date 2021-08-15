package ua.com.alevel.db;

import ua.com.alevel.entity.Note;

import java.util.UUID;

public class NoteDB {

    private Note[] notes = new Note[5];

    public void create(Note note) {
        note.setId(generateId());
        int noteAmount = 0;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] != null) {
                noteAmount++;
            }
        }
        if (noteAmount == notes.length) {
            Note[] tempNotes = new Note[notes.length + 5];
            for (int i = 0; i < notes.length; i++) {
                tempNotes[i] = notes[i];
            }
            notes = tempNotes;
        } else {
            notes[noteAmount] = note;
        }
        System.out.println("Note was successfully added");
    }

    public void update(Note note) {
        int exist = 0;
        for (Note noteCur : notes) {
            if (note.getId().equals(noteCur.getId())) {
                noteCur.setTitle(note.getTitle());
                noteCur.setDescription(note.getDescription());
                System.out.println("Note was successfully updated");
                exist = 1;
                break;
            }
        }
        if (exist == 0) {
            System.out.println("There is no such note in db");
        }
    }

    public void delete(String id) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].getId().equals(id)) {
                for (int j = i; j < notes.length; j++) {
                    if (j != notes.length - 1) {
                        notes[j] = notes[j + 1];
                    } else {
                        notes[j] = null;
                    }
                }
                System.out.println("Note was successfully deleted");
                break;
            }
        }
        System.out.println("There is no such note");
    }

    public Note findById(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        System.out.println("Note was not found");
        return null;
    }

    public Note[] findAll() {
        return notes;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Note note : notes) {
            if (note != null && note.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
