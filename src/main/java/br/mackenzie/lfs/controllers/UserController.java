package br.mackenzie.lfs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@RequestMapping(value = "/home")
	public ModelAndView initialPageForUsers () {
		
		String messageValue = "Successfully logged in.";
		
		ModelAndView mav = new ModelAndView("user");
		mav.addObject("message", messageValue);
		return mav;
		
	}
	
}
