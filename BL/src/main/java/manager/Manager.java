package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.Game;
import core.Solver;
import core.Solvers;
import daointerface.DAO;
import model.game.GameInfo;
import model.game.Step;
import model.game.UserGame;
import model.teaser.Teaser;
import model.teaser.TeaserCondition;
import model.teaser.TeaserConditionClasses;
import model.teaser.TeaserInfo;
import model.teaser.TeaserSolvingInfo;
import model.user.User;
import model.user.UserInfo;
import model.user.UserSolvingInfo;

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
		Solver solver = Solvers.newSolver(cond);
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

	public boolean addUser(User user, UserInfo userInfo){
		User user2 = dao.getByUniqueField(User.class, "login", user.getLogin());
		if (user2 != null) {
			return false;
		}
		dao.saveEntity(user, User.class);
		userInfo.setUserId(user.getUserId());
		dao.saveEntity(userInfo, UserInfo.class);
		return true;
	}

	public int begin(long userId, long teaserId) {
		TeaserInfo teaserInfo = dao.getEntityById(teaserId, TeaserInfo.class);
		Class<? extends TeaserCondition> tClass = TeaserConditionClasses.getTeaserConditionClass(teaserInfo.getType());
		TeaserCondition condition = dao.getEntityById(teaserId, tClass);
		Solver solver = Solvers.newSolver(condition);
		games.put(new UserGame(teaserId, userId), new Game(solver));
		return 0;
	}

	public boolean checkUser(User user){
		User user2 = dao.getByUniqueField(User.class, "login", user.getLogin());
		if (user2 == null) {
			return false;
		}
		return user2.getPassword().equals(user.getPassword());
	}

	public void deleteTeaser(long teaserId){
	}

	public boolean doStep(UserGame game, Step step){
		return false;
	}

	public GameInfo end(UserGame game){
		return null;
	}

	public Step getHint(UserGame game){
		return null;
	}

	public Teaser getSolution(UserGame game){
		return null;
	}

	public TeaserCondition getTeaserCondition(UserGame game){
		return null;
	}

	public List<TeaserInfo> getTeasersInfo(){
		return null;
	}

	public List<TeaserSolvingInfo> getTeasersSolvingInfo(){
		return null;
	}

	public UserInfo getUserInfo(long userId){
		return null;
	}

	public List<UserSolvingInfo> getUsersSolvingInfo(){
		return null;
	}

	public boolean isFinished(UserGame userGame){
		return false;
	}
	
}
