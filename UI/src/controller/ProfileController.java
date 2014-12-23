package controller;

import javax.servlet.http.HttpServletRequest;

import main.ManagerFactory;
import manager.Manager;
import model.ProfileModel;
import model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
	
	private static final Manager mng = ManagerFactory.getManager();

	@RequestMapping("/profile")
	public ModelAndView profile(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("profile");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return modelAndView;
		}
		modelAndView.addObject("profile", new ProfileModel(mng.getUserInfo(user.getUserId()), user));
 		return modelAndView;
	}
	
}
