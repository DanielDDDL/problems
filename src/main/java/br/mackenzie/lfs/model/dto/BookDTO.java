package br.mackenzie.lfs.model.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.mackenzie.lfs.model.Book;
import br.mackenzie.lfs.model.annotations.Unique;

@Unique.List({
	@Unique(entityClass = Book.class, fieldName = "title", message = "Title must be unique"),
	@Unique(entityClass = Book.class, fieldName = "author", message = "Author must be unique")
})
public class BookDTO extends DTO<Book,BookDTO>{

	@Id
    private Long id;
	
	@NotNull
	@Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters")
    private String title;
	
	@NotNull
	@Size(min = 2, max = 30, message = "Author's name must be between 2 and 30 characters")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		
		return true;
	}

}
