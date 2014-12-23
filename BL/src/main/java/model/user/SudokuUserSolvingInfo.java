package model.user;

import javax.persistence.Entity;

import model.teaser.TeaserType;

@Entity
public class SudokuUserSolvingInfo extends UserSolvingTeaserTypeInfo {

	private SudokuUserSolvingInfo() {
		super(null, 0);
	}
	
	public SudokuUserSolvingInfo(long userId) {
		super(TeaserType.SUDOKU, userId);
	}
	
}
