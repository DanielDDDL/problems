package br.mackenzie.lfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EntityScan("br.mackenzie.lfs.model")
@EnableJpaRepositories("br.mackenzie.lfs.dao")
@EnableJpaAuditing
public class Application{

    public static void main (String [] args){
        SpringApplication.run(Application.class, args);
    }

}
