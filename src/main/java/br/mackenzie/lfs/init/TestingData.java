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
import br.mackenzie.lfs.model.Book;
import br.mackenzie.lfs.model.dto.TestingDTO;
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

    }

}
