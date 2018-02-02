package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.model.Book;
import br.mackenzie.lfs.model.dto.UpdateBookDTO;
import br.mackenzie.lfs.util.ObjectMapperUtils;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ModelMapperTest {

    Logger log = LoggerFactory.getLogger(ModelMapper.class);

    @Test
    public void testingModelMapper(){

        Book book = new Book(1L, "Title", "Author", LocalDateTime.now(), LocalDateTime.now());
        UpdateBookDTO newBook = new UpdateBookDTO();
        newBook.setId(1L);
        newBook.setTitle("Something else");

        log.info("Before: " + book.toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(newBook, book);

        log.info("After: " + book.toString());

    }

    @Test
    public void comparing(){

        Book book = new Book(1L, "Title", "Author", LocalDateTime.now(), LocalDateTime.now());
        UpdateBookDTO dto = new UpdateBookDTO(); //TODO REPLACE THIS WITH A RegisterBookDTO and see the difference to understand
        dto.setId(1L);
        dto.setTitle("Something else");

        ModelMapper modelMapper = new ModelMapper();
        Book testingCopy  = modelMapper.map(dto, Book.class);
        modelMapper.map(dto, book);

        log.info("Original: " + book.toString());
        log.info("Copy    : " + testingCopy.toString());

        assertEquals(testingCopy,book);

    }

    @Test
    public void testingAsIfWasTheRealThing() throws InterruptedException {

        LocalDateTime initialValue = LocalDateTime.now();

        // let's assume these values are coming from a database, alright?
        Book fromDatabase = new Book();
        fromDatabase.setId(1L);
        fromDatabase.setTitle("First title");
        fromDatabase.setAuthor("First author");
        fromDatabase.setDateWhenRegistered(initialValue);
        fromDatabase.setDateWhenLastEdited(initialValue);

        // and this one is the request object coming from the view
        UpdateBookDTO updateBook = new UpdateBookDTO();
        updateBook.setId(1L);
        updateBook.setTitle("New title");
        updateBook.setAuthor("New author");
        updateBook.setDateWhenLastEdited(initialValue.plusHours(2L));

        ModelMapper mapper = new ModelMapper();
        mapper.map(updateBook,fromDatabase);

        // so what i'm assuming will happen:
        // the fallowing fields will have their value updated:
        // - title, author and dataWhenLastEdited
        // but the register date will be kept the same
        // hence the fallowing tests

        assertEquals(fromDatabase.getId(), new Long(1));
        assertEquals(fromDatabase.getTitle(), updateBook.getTitle());
        assertEquals(fromDatabase.getAuthor(), updateBook.getAuthor());
        assertEquals(fromDatabase.getDateWhenRegistered(), initialValue);
        assertEquals(fromDatabase.getDateWhenLastEdited(), updateBook.getDateWhenLastEdited());

        log.info("Book results: " + fromDatabase.toString());
    }

}
