package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import core.Game;
import core.Solver;
import core.SolverFactory;
import daointerface.DAO;

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
	
	public boolean addTeaser(TeaserCondition cond, TeaserInfo info, int defDifficulty) {
		Solver solver = SolverFactory.newSolver(cond, info.getTeaserType());
		Teaser solution = solver.solve();
		if (solution == null) {
			return false;
		}
		dao.saveEntity(info);
		solution.setTeaserId(info.getTeaserId());
		dao.saveEntity(solution);
		cond.setTeaserId(info.getTeaserId());
		dao.saveEntity(cond);
		TeaserSolvingInfo solvingInfo = new TeaserSolvingInfo(info.getTeaserId(), defDifficulty);
		dao.saveEntity(solvingInfo);
		return true;
	}

	public boolean addUser(User user, UserInfo userInfo) {
		User user2 = dao.getByUniqueField(User.class, "login", user.getLogin());
		if (user2 != null) {
			return false;
		}
		dao.saveEntity(user);
		userInfo.setUserId(user.getUserId());
		dao.saveEntity(userInfo);
		return true;
	}

	public Teaser begin(UserGame userGame, TeaserType teaserType) {
		Game game = games.get(userGame);
		if (!games.containsKey(userGame)) {
			TeaserInfo teaserInfo = dao.getEntityById(TeaserInfo.class, userGame.getTeaserId());
			Class<? extends TeaserCondition> tClass = TeaserConditionClasses.getTeaserConditionClass(teaserInfo.getTeaserType());
			TeaserCondition condition = dao.getEntityById(tClass, userGame.getTeaserId());
			game = new Game(condition, teaserInfo);
			games.put(userGame, game);
		}
		return game.getTeaser();
	}

	public boolean checkUser(User user) {
		User user2 = dao.getByUniqueField(User.class, "login", user.getLogin());
		if (user2 == null) {
			return false;
		}
		user.setUserId(user2.getUserId());
		user.setRole(user2.getRole());
		return user2.getPassword().equals(user.getPassword());
	}

	public void deleteTeaser(long teaserId) {
		dao.delete(TeaserInfo.class, teaserId);
	}

	public boolean doStep(UserGame userGame, Step step) {
		Game game = games.get(userGame);
		return game.doStep(step);
	}
	
	public TeaserInfo getTeaserInfo(UserGame userGame) {
		Game game = games.get(userGame);
		return game.getTeaserInfo();
	}

	public GameInfo end(UserGame userGame) {
		Game game = games.get(userGame);
		games.remove(userGame);
		GameInfo gameInfo = game.getGameInfo();
		if (game.isFinished()) {
			long tId = userGame.getTeaserId();
			long uId = userGame.getUserId();
			TeaserType teaserType = game.getTeaserInfo().getTeaserType();
			TeaserSolvingInfo teaserSolvingInfo = dao.getEntityById(TeaserSolvingInfo.class, tId);
			if (teaserSolvingInfo == null) {
				teaserSolvingInfo = new TeaserSolvingInfo(tId);
			}
			Class<? extends UserSolvingTeaserTypeInfo> usttiClass = UserSolvingTeaserTypeClasses.getUserSolvingTeaserTypeClass(teaserType);
			UserSolvingTeaserTypeInfo userSolvingTeaserTypeInfo = dao.getEntityById(usttiClass, uId);
			if (userSolvingTeaserTypeInfo == null) {
				userSolvingTeaserTypeInfo = UserSolvingTeaserTypeInfoFactory.newUserSolvingTeaserTypeInfo(uId, teaserType);
			}
			UserSolvingInfo userSolvingInfo = dao.getEntityById(UserSolvingInfo.class, uId);
			if (userSolvingInfo == null) {
				userSolvingInfo = new UserSolvingInfo(uId);
			}
			teaserSolvingInfo.addSolution(gameInfo);
			userSolvingInfo.subtract(userSolvingTeaserTypeInfo.getRating());
			userSolvingTeaserTypeInfo.addSolution(gameInfo);
			userSolvingInfo.add(userSolvingTeaserTypeInfo.getRating());
			userSolvingInfo.addSolution(gameInfo);
			dao.saveEntity(teaserSolvingInfo);
			dao.saveEntity(userSolvingTeaserTypeInfo);
			dao.saveEntity(userSolvingInfo);
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
		return dao.getByUniqueField(game.getTeaser().getClass(), "teaserId", userGame.getTeaserId());
	}

	public TeaserCondition getTeaserCondition(UserGame userGame) {
		Game game = games.get(userGame);
		return game.getTeaserCondition();
	}
	
	public Teaser getTeaser(UserGame userGame) {
		Game game = games.get(userGame);
		return game.getTeaser();
	}

	public List<TeaserInfo> getTeasersInfo() {
		return dao.getAll(TeaserInfo.class);
	}

	public List<TeaserSolvingInfo> getTeasersSolvingInfo(){
		return dao.getAll(TeaserSolvingInfo.class);
	}

	public UserInfo getUserInfo(long userId){
		return dao.getEntityById(UserInfo.class, userId);
	}

	@SuppressWarnings("unchecked")
	public List<UserSolvingTeaserTypeInfo> getUsersSolvingTypeInfo(TeaserType teaserType) {
		return (List<UserSolvingTeaserTypeInfo>) dao.getAll(UserSolvingTeaserTypeClasses.getUserSolvingTeaserTypeClass(teaserType));
	}
	
	public List<UserSolvingInfo> getUsersSolvingInfo() {
		return dao.getAll(UserSolvingInfo.class);
	}

	public boolean isFinished(UserGame userGame){
		Game game = games.get(userGame);
		return game.isFinished();
	}
	
	public List<User> getUsers() {
		return dao.getAll(User.class);
	}
	
}
