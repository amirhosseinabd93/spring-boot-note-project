package ir.arcademy.notes.modules.note.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.arcademy.notes.modules.user.domain.User;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id ;

    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    @Column(name = "title")
    private String title ;

    @Column(name = "body")
    private String body ;

    @JsonIgnore
    @JoinColumn(name = "author_id")
    @ManyToOne
    private User author ;

    @Column(name = "datetime")
    private LocalDateTime dateTime ;

    @ManyToMany
    @JoinTable(name = "notes_categories", joinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName ="id"))
    private List<Category> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDateTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
