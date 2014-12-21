package core;

import model.game.Step;
import model.game.SudokuStep;
import model.teaser.SudokuTeaser;
import model.teaser.SudokuTeaserCondition;
import model.teaser.TeaserCondition;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:27:24
 */
public class SudokuSolver implements Solver {

	private final SudokuTeaserCondition cnd;
	private SudokuTeaser teaser;
	private int finished;
	private int size;
	private int rowsSmallSize;
	private int cmnsSmallSize;
	
	public SudokuSolver(TeaserCondition teaserCondition) {
		cnd = (SudokuTeaserCondition) teaserCondition;
		reset();
	}

	public void reset() {
		teaser = new SudokuTeaser(cnd);
		finished = 0;
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (teaser.get(i, j) != 0) {
					finished++;
				}
			}
		}
		size = cnd.size();
		rowsSmallSize = cnd.rowsSmallSize();
		cmnsSmallSize = cnd.cmnsSmallSize();
	}
	
	@Override
	public SudokuTeaser solve() {
		int[] vsnsX = new int[size*size+1];
		int[] vsnsY = new int[size*size+1];
		int vsn = 0;
		int i = 0;
		int j = 0;
		begin:
		while (!isFinished()) {
			for ( ; ; ++i) {
				for ( ; j < size; ++j) {
					if (teaser.get(i, j) == 0) {
						int k = 1;
						while (true) {
							for ( ; k <= size; ++k) {
								if (doStep(i, j, k)) {
									vsn++;
									vsnsX[vsn] = i;
									vsnsY[vsn] = j;
									continue begin;
								}
							}
							doStep(i, j, 0);
							if (vsn == 0) {
								return null;
							}
							i = vsnsX[vsn];
							j = vsnsY[vsn];
							k = teaser.get(i, j) + 1;
							vsn--;
						}
					}
				}
				j = 0;
			}
		}
		return teaser;
	}

	@Override
	public SudokuStep solveOneStep() {
		SudokuTeaser oldTeaser = teaser;
		int oldFinished = finished;
		teaser = new SudokuTeaser(oldTeaser);
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (teaser.get(i, j) == 0) {
					for (int k = 1; k <= size; ++k) {
						doStep(i, j, k);
						SudokuTeaser resTeaser = solve();
						if (resTeaser != null) {
							System.out.println(teaser);
							teaser = oldTeaser;
							finished = oldFinished;
							doStep(i, j, k);
							return new SudokuStep(i, j, k);
						}
					}
					doStep(i, j, 0);
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public boolean doStep(Step step) {
		SudokuStep sudokuStep = (SudokuStep) step;
		int x = sudokuStep.getX();
		int y = sudokuStep.getY();
		int value = sudokuStep.getValue();
		return doStep(x, y, value);
	}
	
	private boolean doStep(int x, int y, int value) {
		if (!checkSet(x, y, value)) {
			return false;
		}
		updateFinished(x, y, value);
		teaser.set(x, y, value);
		return true;
	}
	
	private void updateFinished(int x, int y, int value) {
		if (value == 0) {
			if (teaser.get(x, y) != 0) {
				finished--;
			}
		} else if (teaser.get(x, y) == 0) {
			finished++;
		}
	}
	
	private boolean checkSet(int x, int y, int value) {
		if (value == 0) {
			return true;
		}
		for (int j = 0; j < cnd.size(); ++j) {
			if (y != j && value == teaser.get(x, j)) {
				return false;
			}
		}
		for (int i = 0; i < cnd.size(); ++i) {
			if (x != i && value == teaser.get(i, y)) {
				return false;
			}
		}
		int x1 =rowsSmallSize*(x/rowsSmallSize);
		int y1 = cmnsSmallSize*(y/cmnsSmallSize);
		for (int i = x1; i < x1 + rowsSmallSize; ++i) {
			for (int j = y1; j < y1 + cmnsSmallSize; ++j) {
				if (x!=i && y!=j && teaser.get(i, j) == value) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isFinished() {
		return finished == cnd.size()*cnd.size();
	}

	@Override
	public SudokuTeaser getTeaser() {
		return teaser;
	}

}