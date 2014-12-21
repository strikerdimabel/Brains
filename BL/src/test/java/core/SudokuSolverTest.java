package core;

import model.game.SudokuStep;
import model.teaser.SudokuTeaser;
import model.teaser.SudokuTeaserCondition;
import model.teaser.TeaserCondition;

import org.junit.Assert;
import org.junit.Test;

public class SudokuSolverTest extends Assert {

	@Test
	public void testSolve() {
		int[][] matrix = new int[][]
	    {
			{8,0,0,4,0,6,0,0,7},
			{0,0,0,0,0,0,4,0,0},
			{0,1,0,0,0,0,6,5,0},
			{5,0,9,0,3,0,7,8,0},
			{0,0,0,0,7,0,0,0,0},
			{0,4,8,0,2,0,1,0,3},
			{0,5,2,0,0,0,0,9,0},
			{0,0,1,0,0,0,0,0,0},
			{3,0,0,9,0,2,0,0,5}
	    };
		TeaserCondition cnd = new SudokuTeaserCondition(matrix);
		SudokuSolver sudokuSolver = new SudokuSolver(cnd);
		SudokuTeaser teaser = sudokuSolver.solve();
		System.out.println(teaser);
	}
	
	@Test
	public void testSolveOneStep() {
		TeaserCondition cnd = new SudokuTeaserCondition();
		SudokuSolver sudokuSolver = new SudokuSolver(cnd);
		SudokuStep step = sudokuSolver.solveOneStep();
		System.out.println(step);
	}

}
