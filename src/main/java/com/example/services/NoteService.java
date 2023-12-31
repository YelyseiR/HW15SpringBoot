package com.example.services;

import com.example.entities.Note;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private long idCounter = 0;

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        note.setId(++idCounter);
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        Long id = note.getId();
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        notes.put(id, note);
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        return notes.get(id);
    }
}
