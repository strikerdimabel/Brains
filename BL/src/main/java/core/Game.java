package core;

import model.game.GameInfo;
import model.game.Step;
import model.teaser.Teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:04
 */
public class Game {

	private final GameInfo gameInfo;
	private final Solver solver;

	public Game(Solver solver){
		gameInfo = new GameInfo();
		this.solver = solver;
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
		return solver.getTeaserManager().doStep(step);
	}

	public boolean isFinished(){
		return solver.getTeaserManager().isFinished();
	}

}