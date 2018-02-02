package br.mackenzie.lfs.init;

import br.mackenzie.lfs.Application;
import br.mackenzie.lfs.dao.BookRepository;
import br.mackenzie.lfs.model.Book;
import br.mackenzie.lfs.model.dto.UpdateBookDTO;
import br.mackenzie.lfs.util.PersistedEntitiesObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestingData {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private BookRepository repo;

    @Autowired
    private PersistedEntitiesObjectMapper mapper;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

        LocalDateTime initialValue = LocalDateTime.now();

        Book book = new Book();
        book.setTitle("First title");
        book.setAuthor("First author");
        book.setDateWhenRegistered(initialValue);
        book.setDateWhenLastEdited(initialValue);

        Book registered = repo.saveAndFlush(book);
        logger.info(registered.toString());

        UpdateBookDTO updateBook = new UpdateBookDTO();
        updateBook.setId(registered.getId());
        updateBook.setTitle("New title");
        updateBook.setAuthor("New author");
        updateBook.setDateWhenLastEdited(initialValue.plusHours(2L));

        Book updatedBook = mapper.convertDTOToEntity(updateBook, Book.class);

        Book newUpdatedBook = repo.saveAndFlush(updatedBook);
        logger.info(newUpdatedBook.toString());

        Book gettingBook = repo.findOne(newUpdatedBook.getId());
        logger.info("From db: " + gettingBook.toString());

    }

}