package ua.com.alevel.controller;

import ua.com.alevel.entity.Note;
import ua.com.alevel.services.NoteService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteController {

    private NoteService noteService = new NoteService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, select the option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("0 - Exit");
        System.out.println("1 - Create a note");
        System.out.println("2 - Update a note");
        System.out.println("3 - Delete the note");
        System.out.println("4 - Find the note by Id");
        System.out.println("5 - Return all notes");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            System.out.println("Please, enter the title");
            String title = reader.readLine();
            System.out.println("Please, enter the description");
            String description = reader.readLine();
            Note note = new Note();
            note.setTitle(title);
            note.setDescription(description);
            noteService.create(note);
        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Please, enter the Id");
            String id = reader.readLine();
            System.out.println("Please, enter the title");
            String title = reader.readLine();
            System.out.println("Please, enter the description");
            String description = reader.readLine();
            Note note = new Note();
            note.setId(id);
            note.setTitle(title);
            note.setDescription(description);
            noteService.update(note);
        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Please, enter the Id");
            String id = reader.readLine();
            noteService.delete(id);
        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Please, enter the Id");
            String id = reader.readLine();
            Note note = noteService.findById(id);
            if (note != null) {
                System.out.println("Note: " + note);
            } else {
                System.out.println("There is no such note");
            }
        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        Note[] notes = noteService.findAll();
        for (Note note : notes) {
            if (note != null) {
                System.out.println("Note: " + note);
            }
        }
        if (notes.length == 0) {
            System.out.println("There is no any note");
        }
    }
}
