package br.mackenzie.lfs.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) boolean error,
                                  @RequestParam(value = "logout", required = false) boolean logout, 
                                  Principal principal) {

        if (principal != null)
            return new ModelAndView("redirect:/users/home");

        ModelAndView mav = new ModelAndView("login");

        if (error)
            return mav.addObject("errorMessage", "Password or username is wrong!");
        if (logout)
            return mav.addObject("successMessage", "Logged out!");

        return mav;
    }
    	
}
