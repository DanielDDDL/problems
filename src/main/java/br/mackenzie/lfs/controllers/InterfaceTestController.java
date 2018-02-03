package br.mackenzie.lfs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.mackenzie.lfs.model.InterfaceX;
import br.mackenzie.lfs.model.InterfaceY;

@Controller
public class InterfaceTestController {

    @Autowired
    private InterfaceY interfaceY;

    @Autowired
    private InterfaceX interfaceX;

    @RequestMapping(value = "/interface/test")
    public ModelAndView interfaceEndPoint(){

        int firstResult = interfaceY.someThirdMethod("Something");
        int secondResult = interfaceX.someThirdMethod("Something as well");

        String message = "Yep, something in here";

        if(firstResult == secondResult)
            message = "They are equal!";

        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", message);
        return mav;
    }

}
