package controller;

import javax.servlet.http.HttpServletRequest;

import main.ManagerFactory;
import manager.Manager;
import model.GameModel;
import model.game.UserGame;
import model.teaser.SudokuTeaserCondition;
import model.teaser.TeaserCondition;
import model.teaser.TeaserInfo;
import model.teaser.TeaserType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

	private static final Manager mng = ManagerFactory.getManager();

	@RequestMapping(value = "/game/{teaserId}")
	public ModelAndView begin(HttpServletRequest request, Integer teaserId) {
		ModelAndView modelAndView = new ModelAndView("game");
		Long userId = (Long) request.getSession().getAttribute("userId");
		// if (userId == null) {
		// modelAndView.addObject("error", "you must login");
		// return modelAndView;
		// }
		int[][] matrix = new int[][] { { 8, 0, 0, 4, 0, 6, 0, 0, 7 },
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0 }, { 0, 1, 0, 0, 0, 0, 6, 5, 0 },
				{ 5, 0, 9, 0, 3, 0, 7, 8, 0 }, { 0, 0, 0, 0, 7, 0, 0, 0, 0 },
				{ 0, 4, 8, 0, 2, 0, 1, 0, 3 }, { 0, 5, 2, 0, 0, 0, 0, 9, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 3, 0, 0, 9, 0, 2, 0, 0, 5 } };
		TeaserCondition cnd = new SudokuTeaserCondition(matrix);
		TeaserInfo teaserInfo = new TeaserInfo();
		teaserInfo.setType(TeaserType.SUDOKU);
		modelAndView.addObject("game", new GameModel(cnd, teaserInfo));
		return modelAndView;
	}

}
