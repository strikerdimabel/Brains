package controller;

import javax.servlet.http.HttpServletRequest;

import main.ManagerFactory;
import manager.Manager;
import model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	private static final Manager mng = ManagerFactory.getManager();

	@RequestMapping("/")
	public String defMain() {
 		return "redirect:/main";
	}

	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("main");
 		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
 		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
 		return new ModelAndView("main");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, String login, String password) {
		ModelAndView modelAndView = new ModelAndView("login");
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		if (!mng.checkUser(user)) {
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		request.getSession().setAttribute("user", user);
		return new ModelAndView("redirect:/main");
	}

	@RequestMapping("/registration")
	public ModelAndView registration() {
 		return new ModelAndView("registration");
	}

}
