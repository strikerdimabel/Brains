package core;

import java.util.EnumMap;
import java.util.Map;

import model.teaser.TeaserCondition;
import model.teaser.TeaserType;

public class SolverFactory {

	private static interface ISolverProvider {
		Solver newSolver(TeaserCondition teaserCondition);
	}
	
	private static final Map<TeaserType, ISolverProvider> solvers = new EnumMap<TeaserType, SolverFactory.ISolverProvider>(TeaserType.class);
	
	static {
		solvers.put(TeaserType.SUDOKU, new ISolverProvider() {
			@Override
			public Solver newSolver(TeaserCondition teaserCondition) {
				return new SudokuSolver(teaserCondition);
			}
		});
//		solvers.put(TeaserType.SNAIL, new ISolverProvider() {
//			@Override
//			public Solver newSolver(TeaserCondition teaserCondition) {
//				return new SnailSolver(teaserCondition);
//			}
//		});
	}
	
	private SolverFactory() {
	}
		
	public static Solver newSolver(TeaserCondition teaserCondition, TeaserType teaserType) {
		return solvers.get(teaserType).newSolver(teaserCondition);
	}
	
}
