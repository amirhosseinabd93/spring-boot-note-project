package ir.arcademy.notes.modules.note.repository;

import ir.arcademy.notes.modules.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findById(long id);

    @Query("SELECT n FROM Note n WHERE n.title LIKE %:title%")
    List<Note> findByTitleLike(@Param("title") String title);

    List<Note> findByAuthorEmail(String email);

    @Query(value = "SELECT n FROM Note as n JOIN n.author AS a WHERE n.title LIKE %:title% AND a.email = :email")
    List<Note> findByAuthorEmailAndTitleLike(@Param("email") String email,@Param("title") String title);

}
