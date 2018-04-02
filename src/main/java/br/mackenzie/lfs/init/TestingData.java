package br.mackenzie.lfs.init;

import br.mackenzie.lfs.dao.UserRepository;
import br.mackenzie.lfs.model.Authority;
import br.mackenzie.lfs.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.mackenzie.lfs.Application;
import br.mackenzie.lfs.dao.BookRepository;
import br.mackenzie.lfs.util.PersistedEntitiesObjectMapper;

import javax.persistence.*;
import java.util.List;

@Component
public class TestingData {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private BookRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PersistedEntitiesObjectMapper mapper;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

<<<<<<< HEAD
        Authority adminAuthority = new Authority();
        adminAuthority.setName("ADMIN");

        User admin = new User();
        admin.setName("Administrador");
        admin.setUsername("lfs@mackenzie.br");
        admin.setAge(20);
        admin.setPassword("123456789");
        admin.addAuthority(adminAuthority);

        userRepo.saveAndFlush(admin);

        Authority userAuthority = new Authority();
        userAuthority.setName("USER");

        User user = new User();
        user.setName("Usuário");
        user.setUsername("user@email.br");
        user.setAge(18);
        user.setPassword("123456789");
        user.addAuthority(userAuthority);

        userRepo.saveAndFlush(user);

=======
//        LocalDateTime initialValue = LocalDateTime.now();
//
//        Book book = new Book();
//        book.setTitle("First title");
//        book.setAuthor("First author");
//        book.setDateWhenRegistered(initialValue);
//        book.setDateWhenLastEdited(initialValue);
//
//        Book registered = repo.saveAndFlush(book);
//        logger.info(registered.toString());

//        UpdateBookDTO updateBook = new UpdateBookDTO();
//        updateBook.setId(registered.getId());
//        updateBook.setTitle("New title");
//        updateBook.setAuthor("New author");
//        updateBook.setDateWhenLastEdited(initialValue.plusHours(2L));
//
//        Book updatedBook = mapper.convertDTOToEntity(updateBook, Book.class);
//
//        Book newUpdatedBook = repo.saveAndFlush(updatedBook);
//        logger.info(newUpdatedBook.toString());
//
//        Book gettingBook = repo.findOne(newUpdatedBook.getId());
//        logger.info("From db: " + gettingBook.toString());

//        TestingDTO testingDTO = new TestingDTO();
//        testingDTO.setId(new Long(1));
//        testingDTO.setTitle("Some random title");
//        
//        Book newUpdatedBook = mapper.convertDTOToEntity(testingDTO, Book.class);
//        logger.info(newUpdatedBook.toString());
//        Book updatedFromDatabase = repo.saveAndFlush(newUpdatedBook);
//        logger.info("Final result: " + updatedFromDatabase.toString());
        
        
        
>>>>>>> e33f9fa5d0b3998d7344f5697d80edc6202a6016
    }

}
