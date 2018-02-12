package br.mackenzie.lfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.mackenzie.lfs.dao.BookRepository;
import br.mackenzie.lfs.model.Book;

@Service
public class BookServiceImp implements BookService {

	private BookRepository repo;
	
	@Autowired
	public BookServiceImp(BookRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void addBook(Book book) {
		repo.save(book);
	}

	@Override
	public void editBook(Book book) {
		
		if(!repo.exists(book.getId()))
			throw new ResourceNotFoundException();
		
		repo.saveAndFlush(book);
		
	}
	
	@Override
	public Book getBook(Long id) {
		return repo.findOne(id);
	}

}
