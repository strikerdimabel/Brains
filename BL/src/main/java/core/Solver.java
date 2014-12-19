package core;

import model.game.Step;
import model.teaser.Teaser;
import model.teaser.TeaserCondition;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:17
 */
public abstract class Solver {

	protected TeaserManager teaserManager;
	protected TeaserCondition teaserCondition;

	public Solver(TeaserCondition teaserCondition){
		this.teaserCondition = teaserCondition;
		init();
	}

	abstract protected void init();
	abstract public Teaser solve();
	abstract public Step solveOneStep();

	/**
	 * @return the teaserManager
	 */
	public TeaserManager getTeaserManager() {
		return teaserManager;
	}

}