package core;

import model.game.Step;
import model.teaser.Teaser;

public class SudokuTeaserManager extends TeaserManager {

	public SudokuTeaserManager(Teaser teaser) {
		super(teaser);
	}

	@Override
	public boolean doStep(Step step) {
		return false;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

}
