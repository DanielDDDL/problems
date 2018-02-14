package br.mackenzie.lfs.model.dto;

import br.mackenzie.lfs.model.SomeExample;

public class SomeExampleDTO extends DTO<SomeExample, SomeExampleDTO> {

	private Long id;
	private String someText;
	
	public SomeExampleDTO() { }
	
	public SomeExampleDTO(Long id, String someText) {
		super();
		this.id = id;
		this.someText = someText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSomeText() {
		return someText;
	}

	public void setSomeText(String someText) {
		this.someText = someText;
	}
	
}
