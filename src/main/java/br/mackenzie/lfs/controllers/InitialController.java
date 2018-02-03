package br.mackenzie.lfs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.mackenzie.lfs.service.SomeService;

@Controller
public class InitialController {

    @Autowired
    private SomeService service;

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    private ModelAndView indexPage(){

        service.someOperation();

        ModelAndView mav = new ModelAndView("jsp/index");
        mav.addObject("message","Hello World!");
        return mav;
    }

    @RequestMapping(value = "/403")
    public ModelAndView accessDeniedPage () {
    	return new ModelAndView("jsp/accessdeniedpage");
    }
    
}
