package ir.arcademy.notes.modules.note.model;

import ir.arcademy.notes.modules.note.domain.Note;

import java.util.List;

public class NoteResponse {
    private List<Note> notes;

    public NoteResponse(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
