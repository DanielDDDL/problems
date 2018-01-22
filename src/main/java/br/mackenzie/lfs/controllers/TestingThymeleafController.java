package br.mackenzie.lfs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestingThymeleafController {

	@RequestMapping(value = "/templating")
	public ModelAndView getHomePage() {
		return new ModelAndView("home");
	}
	
}
