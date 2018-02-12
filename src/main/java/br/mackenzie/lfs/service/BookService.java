package br.mackenzie.lfs.service;

import br.mackenzie.lfs.model.Book;

public interface BookService {

	void addBook(Book book);
	void editBook(Book book);
	Book getBook(Long id);
	
}
