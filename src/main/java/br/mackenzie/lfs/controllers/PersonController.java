package br.mackenzie.lfs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.mackenzie.lfs.model.dto.RegisterBookDTO;

@Controller
@RequestMapping(value = "/book")
public class PersonController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addBookPage(){

        RegisterBookDTO registerBookDTO = new RegisterBookDTO();

        ModelAndView mav = new ModelAndView("book_add");
        mav.addObject("book", registerBookDTO);
        return mav;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addBookProcessing(){
        return null;
    }

}
