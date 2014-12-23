package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("main");
 		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
 		return modelAndView;
	}

	@RequestMapping("/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView("registration");
 		return modelAndView;
	}

	@RequestMapping("/rating")
	public ModelAndView rating() {
		ModelAndView modelAndView = new ModelAndView("rating");
 		return modelAndView;
	}

	@RequestMapping("/profile")
	public ModelAndView profile() {
		ModelAndView modelAndView = new ModelAndView("profile");
 		return modelAndView;
	}

}
