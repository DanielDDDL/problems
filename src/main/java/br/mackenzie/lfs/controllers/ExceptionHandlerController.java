package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.exceptions.DatabaseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlerController {

    @RequestMapping("/raisedatabaseexception")
    public ModelAndView raiseDatabaseException() {
        throw new DatabaseException("Olá, Marilene.");
    }

    @RequestMapping("/raiseillegalstateexception")
    public ModelAndView raiseIllegalStateException() {
        throw new IllegalStateException("Um vinho, tainha e muito sexo :)");
    }

    @ExceptionHandler(DatabaseException.class)
    public ModelAndView databaseExceptionHandler (Exception exception) {

        ModelAndView mv = new ModelAndView("thymeleaf/simplemessage");
        String message = "Database exception: " + exception.toString() ;
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

}
