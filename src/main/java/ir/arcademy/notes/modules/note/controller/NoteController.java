package ir.arcademy.notes.modules.note.controller;

import ir.arcademy.notes.modules.note.domain.Note;
import ir.arcademy.notes.modules.note.model.NoteResponse;
import ir.arcademy.notes.modules.note.service.NoteService;
import ir.arcademy.notes.modules.user.domain.User;
import ir.arcademy.notes.modules.user.service.UserService;
import ir.arcademy.notes.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping
    public ResponseEntity<NoteResponse> getAll(HttpServletRequest request, HttpServletResponse response, @Nullable @RequestParam String title) {

        NoteResponse noteResponse;

        if (title == null) {
            noteResponse = new NoteResponse(noteService.findAll().collect(Collectors.toList()));
        } else {
            noteResponse = new NoteResponse(noteService.findByTitle(title).collect(Collectors.toList()));
        }

        //< Auth block
        /*if (title == null) {
            noteResponse = new NoteResponse(noteService.findByAuthorEmail(authenticationFacade.getAuthentication().getName()).collect(Collectors.toList()));
        }else {
            noteResponse = new NoteResponse(noteService.findByTitleAndAuthorEmail(authenticationFacade.getAuthentication().getName(), title).collect(Collectors.toList()));
        }*/
        // Auth block >
        return new ResponseEntity<>(noteResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> show(@PathVariable("id") long id) {
        Optional<Note> optional = Optional.ofNullable(noteService.findById(id));
        if (!optional.isPresent()) {
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(noteService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@Valid @RequestBody Note note) {
        //< Auth block
        /*User user = userService.findByEmail(authenticationFacade.getAuthentication().getName());
        requestEntity.getBody().setAuthor(user);*/
        // Auth block >
        noteService.save(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity update(@Valid @RequestBody Note note, @PathVariable("id") long id) {
        Optional<Note> optional = Optional.ofNullable(noteService.findById(id));
        if (!optional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        note.setId(id);
        //< Auth block
        /*User user = userService.findByEmail(authenticationFacade.getAuthentication().getName());
        requestEntity.getBody().setAuthor(user);*/
        // Auth block >
        noteService.save(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Optional<Note> optional = Optional.ofNullable(noteService.findById(id));
        if (!optional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        noteService.delete(noteService.findById(id));
        return new ResponseEntity(HttpStatus.OK);
    }
}
