package model.teaser;

import java.util.EnumMap;
import java.util.Map;

import core.Solver;
import core.Solvers;
import core.SudokuSolver;

public class Teasers {
		
	private Teasers() {
	}
		
	public static Teaser newSudokuTeaser(TeaserCondition teaserCondition) {
		return new SudokuTeaser(teaserCondition);
	}
	
}
