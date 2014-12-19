package core;

import java.util.EnumMap;
import java.util.Map;

import model.teaser.TeaserCondition;
import model.teaser.TeaserType;

public class Solvers {

	private static interface ISolverProvider {
		Solver newSolver(TeaserCondition teaserCondition);
	}
	
	private static final Map<TeaserType, ISolverProvider> solvers = new EnumMap<TeaserType, Solvers.ISolverProvider>(TeaserType.class);
	
	static {
		solvers.put(TeaserType.SUDOKU, new ISolverProvider() {
			@Override
			public Solver newSolver(TeaserCondition teaserCondition) {
				return new SudokuSolver(teaserCondition);
			}
		});
		solvers.put(TeaserType.SNAIL, new ISolverProvider() {
			@Override
			public Solver newSolver(TeaserCondition teaserCondition) {
				return new SnailSolver(teaserCondition);
			}
		});
	}
	
	private Solvers() {
	}
		
	public static Solver newSolver(TeaserCondition teaserCondition) {
		return solvers.get(teaserCondition.getTeaserType()).newSolver(teaserCondition);
	}
	
}
