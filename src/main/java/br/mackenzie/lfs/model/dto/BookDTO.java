package br.mackenzie.lfs.model.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.mackenzie.lfs.model.Book;

public class BookDTO extends DTO<Book,BookDTO>{

	@Id
    private Long id;
	
	@NotNull
	@Size(min = 2, max = 30)
    private String title;
	
	@NotNull
	@Size(min = 2, max = 30)
    private String author;

    public BookDTO() { }

    public BookDTO(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
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

}
