package ir.arcademy.notes.modules.note.controller;

import ir.arcademy.notes.modules.note.domain.Category;
import ir.arcademy.notes.modules.note.model.CategoryResponse;
import ir.arcademy.notes.modules.note.model.NoteResponse;
import ir.arcademy.notes.modules.note.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoryResponse> getAll(){
        return new ResponseEntity(new CategoryResponse(categoryService.findAll().collect(Collectors.toList())), HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    @Transactional(readOnly = true)
    public List<Category> getAllByNoteId(@PathVariable("id") Long noteId){
        return categoryService.findAllByNote(noteId).collect(Collectors.toList());
    }

    @PostMapping
    public void save(Category category){
        categoryService.save(category);
    }
}
