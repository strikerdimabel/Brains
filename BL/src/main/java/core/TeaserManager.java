package core;

import model.game.Step;
import model.teaser.Teaser;

public abstract class TeaserManager {

	protected final Teaser teaser;
	
	public TeaserManager(Teaser teaser) {
		this.teaser = teaser;
	}
	
	abstract public boolean doStep(Step step);
	abstract public boolean isFinished();
	
}
