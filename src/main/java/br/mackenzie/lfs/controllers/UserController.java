package br.mackenzie.lfs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/admin_login")
	public ModelAndView loginAdmin(@RequestParam(value = "error",  required = false) boolean error,
								   @RequestParam(value = "logout", required = false) boolean logout) {

		ModelAndView mav = new ModelAndView("jsp/admin_login");
		if(error)
			mav.addObject("message", "Error");
		else if(logout)
			mav.addObject("message", "Logout");

		return mav;
	}

	@RequestMapping(value = "/admin/home")
	public ModelAndView initialPageForAdmins() {

		String messageValue = "Successfully logged in. As admin.";

		ModelAndView mav = new ModelAndView("jsp/admin");
		mav.addObject("message", messageValue);
		return mav;
	}

	@RequestMapping(value = "/user_login")
	public ModelAndView loginUsers(@RequestParam(value = "error",  required = false) boolean error,
								   @RequestParam(value = "logout", required = false) boolean logout) {

		ModelAndView mav = new ModelAndView("jsp/user_login");
		if(error)
			mav.addObject("message", "Error");
		else if(logout)
			mav.addObject("message", "Logout");

		return mav;
	}

	@RequestMapping(value = "/user/home")
	public ModelAndView initialPageForUsers () {

		String messageValue = "Successfully logged in. As user. ";

		ModelAndView mav = new ModelAndView("jsp/user");
		mav.addObject("message", messageValue);
		return mav;

	}

}
