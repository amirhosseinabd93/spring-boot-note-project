package ir.arcademy.notes.modules.note.service;

import ir.arcademy.notes.modules.note.domain.Category;
import ir.arcademy.notes.modules.note.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Stream;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Stream<Category> findAll(){
        return categoryRepository.findAll().stream();
    }

    public Stream<Category> findAllByNote(long noteId){
        return categoryRepository.findAllByNoteId(noteId).stream();
    }

    @Transactional
    public void save(Category category){
        categoryRepository.save(category);
    }

    @Transactional
    public void delete(Category category){
        categoryRepository.delete(category);
    }
}