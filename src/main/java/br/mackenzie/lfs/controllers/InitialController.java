package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InitialController {

    @Autowired
    private SomeService service;

    @RequestMapping(value = {"/","/index","/home"}, method = RequestMethod.GET)
    private ModelAndView indexPage(){

        service.someOperation();

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","Hello World!");
        return mav;
    }

}
