package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.Game;
import core.Solver;
import core.SolverFactory;
import daointerface.DAO;
import model.game.GameInfo;
import model.game.Step;
import model.game.UserGame;
import model.teaser.Teaser;
import model.teaser.TeaserCondition;
import model.teaser.TeaserConditionClasses;
import model.teaser.TeaserInfo;
import model.teaser.TeaserSolvingInfo;
import model.teaser.TeaserType;
import model.user.User;
import model.user.UserInfo;
import model.user.UserSolvingInfo;
import model.user.UserSolvingTeaserTypeClasses;
import model.user.UserSolvingTeaserTypeInfo;
import model.user.UserSolvingTeaserTypeInfoFactory;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:24
 */
public class Manager {
	
	private final DAO dao;
	private final Map<UserGame, Game> games = new HashMap<UserGame, Game>();

	public Manager(DAO dao) {
		this.dao = dao;
	}
	
	public boolean addTeaser(TeaserCondition cond, TeaserInfo info) {
		Solver solver = SolverFactory.newSolver(cond);
		Teaser solution = solver.solve();
		if (solution == null) {
			return false;
		}
		dao.saveEntity(info, TeaserInfo.class);
		solution.setTeaserId(info.getTeaserId());
		dao.saveEntity(solution, solution.getClass());
		cond.setTeaserId(info.getTeaserId());
		dao.saveEntity(cond, cond.getClass());
		return true;
	}

	public boolean addUser(User user, UserInfo userInfo) {
		User user2 = dao.getByUniqueField(User.class, "login", user.getLogin());
		if (user2 != null) {
			return false;
		}
		dao.saveEntity(user, User.class);
		userInfo.setUserId(user.getUserId());
		dao.saveEntity(userInfo, UserInfo.class);
		return true;
	}

	public Teaser begin(UserGame userGame) {
		Game game = games.get(userGame);
		if (!games.containsKey(userGame)) {
			TeaserInfo teaserInfo = dao.getEntityById(userGame.getTeaserId(), TeaserInfo.class);
			Class<? extends TeaserCondition> tClass = TeaserConditionClasses.getTeaserConditionClass(teaserInfo.getType());
			TeaserCondition condition = dao.getEntityById(userGame.getTeaserId(), tClass);
			game = new Game(condition);
			games.put(userGame, game);
		}
		return game.getTeaser();
	}

	public boolean checkUser(User user) {
		User user2 = dao.getByUniqueField(User.class, "login", user.getLogin());
		if (user2 == null) {
			return false;
		}
		return user2.getPassword().equals(user.getPassword());
	}

	public void deleteTeaser(long teaserId) {
		dao.delete(teaserId, TeaserInfo.class);
	}

	public boolean doStep(UserGame userGame, Step step) {
		Game game = games.get(userGame);
		return game.doStep(step);
	}

	public GameInfo end(UserGame userGame) {
		Game game = games.get(userGame);
		games.remove(userGame);
		GameInfo gameInfo = game.getGameInfo();
		if (game.isFinished()) {
			long tId = userGame.getTeaserId();
			long uId = userGame.getUserId();
			TeaserType teaserType = game.getTeaserCondition().getTeaserType();
			TeaserSolvingInfo teaserSolvingInfo = dao.getEntityById(tId, TeaserSolvingInfo.class);
			if (teaserSolvingInfo == null) {
				teaserSolvingInfo = new TeaserSolvingInfo(tId);
			}
			Class<? extends UserSolvingTeaserTypeInfo> usttiClass = UserSolvingTeaserTypeClasses.getUserSolvingTeaserTypeClass(teaserType);
			UserSolvingTeaserTypeInfo userSolvingTeaserTypeInfo = dao.getEntityById(uId, usttiClass);
			if (userSolvingTeaserTypeInfo == null) {
				userSolvingTeaserTypeInfo = UserSolvingTeaserTypeInfoFactory.newUserSolvingTeaserTypeInfo(uId, teaserType);
			}
			UserSolvingInfo userSolvingInfo = dao.getEntityById(uId, UserSolvingInfo.class);
			if (userSolvingInfo == null) {
				userSolvingInfo = new UserSolvingInfo(uId);
			}
			teaserSolvingInfo.addSolution(gameInfo);
			userSolvingInfo.subtract(userSolvingTeaserTypeInfo.getRating());
			userSolvingTeaserTypeInfo.addSolution(gameInfo);
			userSolvingInfo.add(userSolvingTeaserTypeInfo.getRating());
			userSolvingInfo.addSolution(gameInfo);
			dao.saveEntity(teaserSolvingInfo, TeaserSolvingInfo.class);
			dao.saveEntity(userSolvingTeaserTypeInfo, UserSolvingTeaserTypeClasses.getUserSolvingTeaserTypeClass(teaserType));
			dao.saveEntity(userSolvingInfo, UserSolvingTeaserTypeInfo.class);
		}
		return gameInfo;
	}

	public Step getHint(UserGame userGame) {
		Game game = games.get(userGame);
		return game.doHintStep();
	}

	public Teaser getSolution(UserGame userGame) {
		Game game = games.get(userGame);
		game.autoSolve();
		return dao.getEntityById(userGame.getTeaserId(), game.getTeaser().getClass());
	}

	public TeaserCondition getTeaserCondition(UserGame userGame) {
		Game game = games.get(userGame);
		return game.getTeaserCondition();
	}

	public List<TeaserInfo> getTeasersInfo() {
		return dao.getAll(TeaserInfo.class);
	}

	public List<TeaserSolvingInfo> getTeasersSolvingInfo(){
		return dao.getAll(TeaserSolvingInfo.class);
	}

	public UserInfo getUserInfo(long userId){
		return dao.getEntityById(userId, UserInfo.class);
	}

	public List<UserSolvingTeaserTypeInfo> getUsersSolvingInfo(){
		return dao.getAll(UserSolvingTeaserTypeInfo.class);
	}

	public boolean isFinished(UserGame userGame){
		Game game = games.get(userGame);
		return game.isFinished();
	}
	
}
