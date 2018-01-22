package br.mackenzie.lfs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestingThymeleafController {

	@RequestMapping(value = "/th")
	public ModelAndView getHomePage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/jsp")
	public ModelAndView getAnotherPage() {
		return new ModelAndView("index");
	}
	
}
