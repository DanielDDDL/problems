package br.mackenzie.lfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SomeExample {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String someText;
	
	@Column
	private String someOtherText;

	public SomeExample () { } 
	
	public SomeExample(Long id, String someText, String someOtherText) {
		this.id = id;
		this.someText = someText;
		this.someOtherText = someOtherText;
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

	public String getSomeOtherText() {
		return someOtherText;
	}

	public void setSomeOtherText(String someOtherText) {
		this.someOtherText = someOtherText;
	}
	
}
