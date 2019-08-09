package ir.arcademy.notes.modules.note.model;

import ir.arcademy.notes.modules.note.domain.Category;
import ir.arcademy.notes.modules.note.domain.Note;

import java.util.List;

public class CategoryResponse {
    private List<Category> categories;

    public CategoryResponse(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
