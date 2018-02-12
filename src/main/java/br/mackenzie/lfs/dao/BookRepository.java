package br.mackenzie.lfs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.mackenzie.lfs.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

	@Query("SELECT B FROM Book B WHERE B.title like :title")
	Book findBookByTitle (String query);
	
}
