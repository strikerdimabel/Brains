package controller;

import main.ManagerFactory;
import manager.Manager;
import model.RatingModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RatingController {
	
	private static final Manager mng = ManagerFactory.getManager();

	@RequestMapping("/rating")
	public ModelAndView rating() {
		ModelAndView modelAndView = new ModelAndView("rating");
		modelAndView.addObject("rating", new RatingModel(mng.getUsersSolvingInfo(), mng.getUsers()));
 		return modelAndView;
	}

}
