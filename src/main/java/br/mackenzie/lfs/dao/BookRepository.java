package br.mackenzie.lfs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mackenzie.lfs.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
