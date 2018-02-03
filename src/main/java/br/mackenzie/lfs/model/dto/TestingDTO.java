package br.mackenzie.lfs.model.dto;

import javax.persistence.Id;

import br.mackenzie.lfs.model.Book;

public class TestingDTO extends DTO <Book> {
	
	@Id
	private Long id;
	private String title;
	
	public TestingDTO () { }
	
	public TestingDTO(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
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
	
}
