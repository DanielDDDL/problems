package br.mackenzie.lfs.model.dto;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class UpdateBookDTO {

    @Id
    private Long id;
    private String title;
    private String author;
    private LocalDateTime dateWhenLastEdited;

    public UpdateBookDTO() { }

    public UpdateBookDTO(Long id, String title, String author, LocalDateTime dateWhenLastEdited) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateWhenLastEdited = dateWhenLastEdited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateWhenLastEdited() {
        return dateWhenLastEdited;
    }

    public void setDateWhenLastEdited(LocalDateTime dateWhenLastEdited) {
        this.dateWhenLastEdited = dateWhenLastEdited;
    }

}
