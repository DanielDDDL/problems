package br.mackenzie.lfs;

import br.mackenzie.lfs.dao.BookRepository;
import br.mackenzie.lfs.model.Book;
import br.mackenzie.lfs.model.dto.UpdateBookDTO;
import br.mackenzie.lfs.util.PersistedEntitiesObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EntityScan("br.mackenzie.lfs.model")
@EnableJpaRepositories("br.mackenzie.lfs.dao")
public class Application{

    public static void main (String [] args){
        SpringApplication.run(Application.class, args);
    }

}
