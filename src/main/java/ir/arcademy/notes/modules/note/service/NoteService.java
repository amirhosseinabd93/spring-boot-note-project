package ir.arcademy.notes.modules.note.service;

import ir.arcademy.notes.modules.note.domain.Note;
import ir.arcademy.notes.modules.note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Stream<Note> findAll(){
        return noteRepository.findAll().stream();
    }

    public Stream<Note> findByTitle(String title){
        return noteRepository.findByTitleLike(title).stream();
    }

    public Stream<Note> findByAuthorEmail(String email){
        return noteRepository.findByAuthorEmail(email).stream();
    }

    public Stream<Note> findByTitleAndAuthorEmail(String email, String title){
        return noteRepository.findByAuthorEmailAndTitleLike(email, title).stream();
    }

    public Note findById(long id){
        return noteRepository.findById(id);
    }

    @Transactional
    public void save(Note note){
        note.setDateTime(LocalDateTime.now());
        noteRepository.save(note);
    }

    @Transactional
    public void delete(Note note){
        noteRepository.delete(note);
    }
}
