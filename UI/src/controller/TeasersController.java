package controller;

import main.ManagerFactory;
import manager.Manager;
import model.TeasersModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeasersController {

	private static final Manager mng = ManagerFactory.getManager();

	@RequestMapping("/teasers")
	public ModelAndView teasers() {
		ModelAndView modelAndView = new ModelAndView("teasers");
		modelAndView.addObject("teasers", new TeasersModel(mng.getTeasersInfo(), mng.getTeasersSolvingInfo()));
 		return modelAndView;
	}

}
