package model.teaser;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:25
 */
@Entity
public class SudokuTeaser extends Teaser {

	@Lob
	private final int[][] matrix;
	
	private final int size;

	@SuppressWarnings("unused")
	private SudokuTeaser() {
		size = 0;
		matrix = null;
	}
	
	public SudokuTeaser(SudokuTeaserCondition teaserCondition) {
		size = teaserCondition.size();
		matrix = new int[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				matrix[i][j] = teaserCondition.get(i, j);
			}
		}
	}

	public SudokuTeaser(SudokuTeaser teaser) {
		size = teaser.size();
		matrix = new int[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				matrix[i][j] = teaser.get(i, j);
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}