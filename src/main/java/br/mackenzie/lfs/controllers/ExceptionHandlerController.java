package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.exceptions.DatabaseException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlerController {

    @RequestMapping("/raisedatabaseexception")
    public ModelAndView raiseDatabaseException() {
        throw new DatabaseException("Olá, Marilene ", 5);
    }

    //more specific, it will catch when the method about get executed, even tough there is a ControllerAdvice for this
    @ExceptionHandler(DatabaseException.class)
    public ModelAndView databaseException (DatabaseException exception) {

        ModelAndView mv = new ModelAndView("thymeleaf/simplemessage");
        String message = "Local handler: " + exception.toString() + exception.getQnt();
        mv.addObject("message", message);
        return mv;

    }

    @RequestMapping("/raiseillegalstateexception")
    public ModelAndView raiseIllegalStateException() {
        throw new IllegalStateException("Um vinho, tainha e muito sexo :)");
    }

    @RequestMapping("/raisenotfoundexception")
    public ModelAndView raiseNotFoundException () {
        throw new ResourceNotFoundException();
    }

}
