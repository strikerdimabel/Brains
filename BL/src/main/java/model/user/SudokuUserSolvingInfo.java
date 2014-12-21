package model.user;

import model.teaser.TeaserType;

public class SudokuUserSolvingInfo extends UserSolvingTeaserTypeInfo {

	public SudokuUserSolvingInfo(long userId) {
		super(userId, TeaserType.SUDOKU);
	}

}
