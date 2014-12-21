package model.teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:29
 */
public class SudokuTeaserCondition extends TeaserCondition {

	private final int size = 9;
	private final int rowsSmall = 3;
	private final int cmnsSmall = 3;
	private int[][] matrix = new int[size][size];

	public SudokuTeaserCondition() {
	}
		
	public SudokuTeaserCondition(int[][] matrix) {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}
	
	public int get(int i, int j) {
		return matrix[i][j];
	}

	public void set(int i, int j, int value) {
		matrix[i][j] = value;
	}
	
	public int size() {
		return size;
	}
		
	public int rowsSmallSize() {
		return rowsSmall;
	}

	public int cmnsSmallSize() {
		return cmnsSmall;
	}

}