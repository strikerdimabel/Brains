package core;

import model.game.GameInfo;
import model.game.Step;
import model.teaser.Teaser;
import model.teaser.TeaserCondition;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:04
 */
public class Game {

	private final GameInfo gameInfo;
	private final Solver solver;
	private final TeaserCondition teaserCondition;

	public Game(TeaserCondition teaserCondition){
		gameInfo = new GameInfo();
		this.solver = Solvers.newSolver(teaserCondition);
		this.teaserCondition = teaserCondition;
	}

	public Teaser autoSolve() {
		gameInfo.setAutoSolved();
		return solver.solve();
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

}