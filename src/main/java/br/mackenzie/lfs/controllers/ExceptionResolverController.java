package br.mackenzie.lfs.controllers;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import br.mackenzie.lfs.exceptions.DatabaseException;

@ControllerAdvice
public class ExceptionResolverController {

    @ExceptionHandler(DatabaseException.class)
    public ModelAndView databaseExceptionHandler (DatabaseException exception) {

        ModelAndView mv = new ModelAndView("thymeleaf/simplemessage");
        String message = "Global Handler: " + exception.toString();
        mv.addObject("message", message);
        return mv;

    }

    @ExceptionHandler(IllegalStateException.class)
    public ModelAndView illegalStateException (IllegalStateException exception) {

        ModelAndView mv = new ModelAndView("thymeleaf/simplemessage");
        String message = "Illegal state exception: " + exception.toString() ;
        mv.addObject("message", message);
        return mv;

    }

    @ExceptionHandler({NoHandlerFoundException.class, ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView noHandlerFoundResolver () {

        ModelAndView mv = new ModelAndView("thymeleaf/simplemessage");
        String message = "Simple 404 page";
        mv.addObject("message", message);
        return mv;

    }

}
