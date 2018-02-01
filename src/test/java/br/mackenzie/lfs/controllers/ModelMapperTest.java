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

}
