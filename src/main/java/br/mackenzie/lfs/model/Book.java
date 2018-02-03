package br.mackenzie.lfs.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private LocalDateTime dateWhenRegistered;

    @Column(nullable = false)
    private LocalDateTime dateWhenLastEdited;

    public Book () {}

    public Book(Long id, String title, String author, LocalDateTime dateWhenRegistered, LocalDateTime dateWhenLastEdited) {
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

    @Override
    public String toString() {
        return "Book { " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dateWhenRegistered=" + dateWhenRegistered +
                ", dateWhenLastEdited=" + dateWhenLastEdited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (dateWhenRegistered != null ? !dateWhenRegistered.equals(book.dateWhenRegistered) : book.dateWhenRegistered != null)
            return false;
        return dateWhenLastEdited != null ? dateWhenLastEdited.equals(book.dateWhenLastEdited) : book.dateWhenLastEdited == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (dateWhenRegistered != null ? dateWhenRegistered.hashCode() : 0);
        result = 31 * result + (dateWhenLastEdited != null ? dateWhenLastEdited.hashCode() : 0);
        return result;
    }
}
