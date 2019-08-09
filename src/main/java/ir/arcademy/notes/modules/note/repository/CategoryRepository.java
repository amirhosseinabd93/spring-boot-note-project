package ir.arcademy.notes.modules.note.repository;

import ir.arcademy.notes.modules.note.domain.Category;
import ir.arcademy.notes.modules.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Note AS n INNER JOIN n.categories AS c WHERE n.id = :noteId ")
    List<Category> findAllByNoteId(@Param("noteId")Long noteId);
}
