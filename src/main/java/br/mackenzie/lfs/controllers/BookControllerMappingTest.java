package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.dao.BookRepository;
import br.mackenzie.lfs.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/book")
public class BookControllerMappingTest {

//    @Autowired
//    private BookRepository repo;
//
//    @RequestMapping("/test")
//    public String testingUpdateBook() {
//
//        return "index";
//    }
//
//    @RequestMapping("/reset")
//    public String reset(){
//        repo.deleteAll();
//        return "index";
//    }
}
