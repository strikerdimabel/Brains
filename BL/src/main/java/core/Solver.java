package core;

import model.game.Step;
import model.teaser.Teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:17
 */
public interface Solver {

	Teaser solve();
	Step solveOneStep();
	boolean doStep(Step step);
	boolean isFinished();
	Teaser getTeaser();

}