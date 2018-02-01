package br.mackenzie.lfs.model.dto;

import java.time.LocalDateTime;

public class RegisterBookDTO {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime dateWhenRegistered;
    private LocalDateTime dateWhenLastEdited;

    public RegisterBookDTO() { }

    public RegisterBookDTO(Long id, String title, String author, LocalDateTime dateWhenRegistered, LocalDateTime dateWhenLastEdited) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateWhenRegistered = dateWhenRegistered;
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

    public LocalDateTime getDateWhenRegistered() {
        return dateWhenRegistered;
    }

    public void setDateWhenRegistered(LocalDateTime dateWhenRegistered) {
        this.dateWhenRegistered = dateWhenRegistered;
    }

    public LocalDateTime getDateWhenLastEdited() {
        return dateWhenLastEdited;
    }

    public void setDateWhenLastEdited(LocalDateTime dateWhenLastEdited) {
        this.dateWhenLastEdited = dateWhenLastEdited;
    }
}
