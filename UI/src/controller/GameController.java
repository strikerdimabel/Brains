package controller;

import javax.servlet.http.HttpServletRequest;

import main.ManagerFactory;
import manager.Manager;
import model.GameModel;
import model.game.Step;
import model.game.UserGame;
import model.teaser.Teaser;
import model.teaser.TeaserCondition;
import model.teaser.TeaserInfo;
import model.teaser.TeaserType;
import model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

	private static final Manager mng = ManagerFactory.getManager();

	@RequestMapping(value = "/begin/{teaserId}", method = RequestMethod.GET)
	public String begin(HttpServletRequest request,
			@PathVariable("teaserId") Integer teaserId, String teaserType) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/game/" + teaserId;
		}
		UserGame userGame = new UserGame(teaserId, user.getUserId());
		mng.begin(userGame, TeaserType.valueOf(teaserType));
		return "redirect:/game/" + teaserId;
	}

	@RequestMapping(value = "/game/{teaserId}", method = RequestMethod.GET)
	public ModelAndView begin(HttpServletRequest request,
			@PathVariable("teaserId") Integer teaserId) {
		ModelAndView modelAndView = new ModelAndView("game");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return modelAndView;
		}
		UserGame userGame = new UserGame(teaserId, user.getUserId());
		TeaserCondition cnd = mng.getTeaserCondition(userGame);
		TeaserInfo teaserInfo = mng.getTeaserInfo(userGame);
		modelAndView.addObject("game", new GameModel(mng.getTeaser(userGame),
				cnd, teaserInfo));
		return modelAndView;
	}

	@RequestMapping(value = "/game/{teaserId}", method = RequestMethod.POST)
	public @ResponseBody Boolean doStep(HttpServletRequest request,
			@PathVariable("teaserId") Integer teaserId, @RequestBody Step step) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return false;
		}
		UserGame userGame = new UserGame(teaserId, user.getUserId());
		return mng.doStep(userGame, step);
	}

	@RequestMapping(value = "/getHint/{teaserId}", method = RequestMethod.POST)
	public @ResponseBody Step getHint(HttpServletRequest request,
			@PathVariable("teaserId") Integer teaserId) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return null;
		}
		UserGame userGame = new UserGame(teaserId, user.getUserId());
		return mng.getHint(userGame);
	}

	@RequestMapping(value = "/autoSolution/{teaserId}", method = RequestMethod.POST)
	public @ResponseBody Teaser getAutoSolution(HttpServletRequest request,
			@PathVariable("teaserId") Integer teaserId) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return null;
		}
		UserGame userGame = new UserGame(teaserId, user.getUserId());
		Teaser teaser = mng.getSolution(userGame);
		mng.end(userGame);
		return teaser;
	}
}
