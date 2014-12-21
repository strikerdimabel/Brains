package core;

import model.game.GameInfo;
import model.game.Step;
import model.teaser.Teaser;
import model.teaser.TeaserCondition;
import model.teaser.TeaserType;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:04
 */
public class Game {

	private final GameInfo gameInfo;
	private final Solver solver;
	private final TeaserCondition teaserCondition;
	private final TeaserType teaserType;
	
	public Game(TeaserCondition teaserCondition, TeaserType teaserType){
		gameInfo = new GameInfo();
		this.solver = SolverFactory.newSolver(teaserCondition, teaserType);
		this.teaserCondition = teaserCondition;
		this.teaserType = teaserType;
	}

	public void autoSolve() {
		gameInfo.setAutoSolved();
	}

	public Step doHintStep(){
		gameInfo.incHintCount();
		return solver.solveOneStep();
	}

	public boolean doStep(Step step){
		return solver.doStep(step);
	}

	public boolean isFinished(){
		return solver.isFinished();
	}
	
	/**
	 * @return the teaserCondition
	 */
	public TeaserCondition getTeaserCondition() {
		return teaserCondition;
	}
	
	public Teaser getTeaser() {
		return solver.getTeaser();
	}
	
	public GameInfo getGameInfo() {
		return gameInfo;
	}

	/**
	 * @return the type
	 */
	public TeaserType getTeaserType() {
		return teaserType;
	}

}